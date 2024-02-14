package com.folksdev.basicauth.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")

public class PublicController {

    @GetMapping
    public String helloWorld() {
        return "Hello World! from public endpoint";
    }
}