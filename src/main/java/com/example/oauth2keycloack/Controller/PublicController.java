package com.example.oauth2keycloack.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class PublicController {
    @GetMapping
    public String publicEndpoint() {
        return "This is a public endpoint.";
    }
}