package com.itec.app.Controller;


import com.itec.app.Dto.ProductDto;
import com.itec.app.Entity.User;
import com.itec.app.Repository.UserRepository;
import com.itec.app.Security.Jwt.JwtProvider;
import com.itec.app.Security.Services.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SortController {

    @Autowired
    SortService sortService;

    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value="/api/category={categ}", method = RequestMethod.GET)
    private List<ProductDto> getProductsByCateg(@PathVariable("categ") String categ, @RequestHeader(name="Authorization") String token) {
        Long userId=0L;
        String city="";
        if (token != null && token.startsWith("Bearer ")) {
            token.replace("Bearer ", "");
            String email = jwtProvider.getUserNameFromJwtToken(token);
            User user = userRepository.findByEmail(email).get();
            userId=user.getId();
            city=user.getCity();
        }
        return sortService.getProductsByCategory(categ, userId, city);
    }

    @RequestMapping(value="/api/subcategory={subcateg}", method = RequestMethod.GET)
    private List<ProductDto> getProductsBySubcateg(@PathVariable("subcateg") String subcateg, @RequestHeader (name="Authorization") String token) {
        Long userId=0L;
        String city="";
        if (token != null && token.startsWith("Bearer ")) {
            token.replace("Bearer ", "");
            String email = jwtProvider.getUserNameFromJwtToken(token);
            User user = userRepository.findByEmail(email).get();
            userId=user.getId();
            city=user.getCity();
        }
        return sortService.getProductsBySubcategory(subcateg, userId, city);
    }

    @RequestMapping(value="api/sortAscendingPrice")
    private List<ProductDto> sortAscending(@RequestHeader (name="Authorization") String token) {
        Long userId=0L;
        String city="";
        if (token != null && token.startsWith("Bearer ")) {
            token.replace("Bearer ", "");
            String email = jwtProvider.getUserNameFromJwtToken(token);
            User user = userRepository.findByEmail(email).get();
            userId=user.getId();
            city=user.getCity();
        }
        return sortService.sortAscending(userId, city);
    }

    @RequestMapping(value="api/sortDescendingPrice", method = RequestMethod.GET)
    private List<ProductDto> sortDescending(@RequestHeader (name="Authorization") String token) {
        Long userId=0L;
        String city="";
        if (token != null && token.startsWith("Bearer ")) {
            token.replace("Bearer ", "");
            String email = jwtProvider.getUserNameFromJwtToken(token);
            User user = userRepository.findByEmail(email).get();
            userId=user.getId();
            city=user.getCity();
        }
        return sortService.sortDescending(userId, city);
    }

    @RequestMapping(value="api/location={location}", method = RequestMethod.GET)
    private List<ProductDto> sortByLocation(@PathVariable("location") String location, @RequestHeader (name="Authorization") String token) {
        Long userId=0L;
        if (token != null && token.startsWith("Bearer ")) {
            token.replace("Bearer ", "");
            String email = jwtProvider.getUserNameFromJwtToken(token);
            User user = userRepository.findByEmail(email).get();
            userId=user.getId();
        }
        return sortService.sortByLocation(location, userId);
    }

    @RequestMapping(value="api/user={lastName}", method = RequestMethod.GET)
    private List<ProductDto> sortByUser(@PathVariable("lastName") String lastName, @RequestHeader (name="Authorization") String token) {
        Long userId=0L;
        if (token != null && token.startsWith("Bearer ")) {
            token.replace("Bearer ", "");
            String email = jwtProvider.getUserNameFromJwtToken(token);
            User user = userRepository.findByEmail(email).get();
            userId=user.getId();
        }
        return sortService.sortByUser(lastName, userId);
    }

}
