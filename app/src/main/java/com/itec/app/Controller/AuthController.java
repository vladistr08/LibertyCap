package com.itec.app.Controller;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServlet;
import javax.validation.Valid;


import com.itec.app.Email.EmailServiceImpl;
import com.itec.app.Email.MIMEServiceImpl;
import com.itec.app.Entity.Role;
import com.itec.app.Entity.RoleName;
import com.itec.app.Entity.User;
import com.itec.app.Message.request.LoginForm;
import com.itec.app.Message.request.SignUpForm;
import com.itec.app.Message.response.JwtResponse;
import com.itec.app.Repository.RoleRepository;
import com.itec.app.Repository.UserRepository;
import com.itec.app.Security.Jwt.JwtProvider;
import com.sun.mail.iap.Response;
import org.aspectj.weaver.patterns.ExactTypePattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    EmailServiceImpl emailService;

    @Autowired
    MIMEServiceImpl mimeService;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginForm loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail()).get();

        if(user.getHasConfirmed()==true)
        {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getEmail(),
                            loginRequest.getPassword()
                    )
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);

            String jwt = jwtProvider.generateJwtToken(authentication);
            User user1 = userRepository.findUserById(userRepository.findIdByEmail(jwtProvider.getUserNameFromJwtToken(jwt)));
            Set<Role> roles = user1.getRoles();
            List<Role> roleList = new ArrayList<>(roles);
            String roleName = roleList.get(0).getName().name();
            String role;
            if(roleName.equals("ROLE_SELLER"))
                role="seller";
            else
                role="buyer";
            return ResponseEntity.ok(new JwtResponse(jwt, role));
        } else {
            return ResponseEntity.ok().body("You need to confirm your account first");
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@RequestBody SignUpForm signUpRequest) {

        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity<String>("Fail -> Email is already in use!",
                    HttpStatus.BAD_REQUEST);
        }

        // Creating user's account
        if(signUpRequest.getType()==null)
            signUpRequest.setType("Company");
        if(signUpRequest.getPassword()==null)
            System.out.println("NULL PASSSWWWWOOOOORDDDDD");
        User user = new User(signUpRequest.getFirstName(), signUpRequest.getLastName(),
                signUpRequest.getPhone(), signUpRequest.getEmail(),
                signUpRequest.getStreetNo(), signUpRequest.getHouseNo(),
                signUpRequest.getPostalCode(), signUpRequest.getType(),
                encoder.encode(signUpRequest.getPassword()), signUpRequest.getCity());

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        strRoles.forEach(role -> {
            switch(role) {
                case "buyer":
                    Role buyerRole = roleRepository.findByName(RoleName.ROLE_BUYER)
                            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
                    roles.add(buyerRole);
                    break;
                default:
                    Role sellerRole = roleRepository.findByName(RoleName.ROLE_SELLER)
                            .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
                    roles.add(sellerRole);
            }
        });
        user.setRoles(roles);
        user.setHasConfirmed(false);

        try {

            userRepository.save(user);

            String to = user.getEmail();
            String subject = "Sign up into iVandut";
            String text = "Welcome to iVandut! Please confirm your account: " + "http://localhost:8081/api/auth/confirmation="+ jwtProvider.generateJwtTokenForConfirmation(user.getEmail());

            emailService.sendSimpleMessage(to, subject, text);


            return ResponseEntity.ok().body("User registered successfully!");
        } catch (Exception e) {
            System.out.println(e.getCause());
            return ResponseEntity.ok().body("A problem has occurred");
        }
    }

    @RequestMapping(value="/confirmation={token}", method = RequestMethod.GET)
    private String confirmationMail(@PathVariable("token") String token) {
        String username = jwtProvider.getUserNameFromJwtToken(token);
        User user = userRepository.findByEmail(username).get();
        if(user!=null) {
            if(user.getHasConfirmed()==false) {
                user.setHasConfirmed(true);
                userRepository.save(user);
                //return ResponseEntity.ok().body("User has confirmed");
                return "User has confirmed";
            } else {
               // return ResponseEntity.ok().body("User has already confirmed");
                return "User has already confirmed";
            }
        } else {
            userRepository.delete(user);
            //return ResponseEntity.ok().body("Token has expired");
            return "Token has expired";
        }
    }


}
