package com.makersharks.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {

    @GetMapping
    public String test(){
        return "Health Check Ok!!";
    }
}
