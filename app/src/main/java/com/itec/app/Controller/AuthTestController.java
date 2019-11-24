package com.itec.app.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthTestController {

    @GetMapping("/api/test/buyer")
    @PreAuthorize("hasRole('BUYER')")
    public String userAccess() {
        return ">>> Buyer Contents!";
    }
}
