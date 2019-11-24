package com.itec.app.Controller;


import com.itec.app.Dto.ProductDto;
import com.itec.app.Entity.Product;
import com.itec.app.Entity.User;
import com.itec.app.Repository.UserRepository;
import com.itec.app.Security.Jwt.JwtProvider;
import com.itec.app.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductsController {

    @Autowired
    ProductService productService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    JwtProvider jwtProvider;

    @PreAuthorize("hasRole('SELLER')")
    @RequestMapping(value="/product/post", method = RequestMethod.POST)
    private Product postProduct(@RequestBody ProductDto productDto) {
        return productService.postProduct(productDto);
    }

    @RequestMapping(value="/api/product/get={id}", method = RequestMethod.GET)
    private ProductDto postProduct(@PathVariable("id") Long id) {
        return productService.getProduct(id);
    }

    @RequestMapping(value="/api/products", method = RequestMethod.GET)
    private List<ProductDto> getAllProductsInRange(@RequestHeader (name="Authorization") String token) {
        if (token != null && token.startsWith("Bearer ")) {
            token.replace("Bearer ","");
            String email = jwtProvider.getUserNameFromJwtToken(token);
            User user = userRepository.findByEmail(email).get();
            return productService.getAllProducts(user.getId(), user.getCity());
        } else {
            return productService.getAll();
        }
    }
}
