package com.security.notes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


    @GetMapping
    public String getUser(){
        return "/hello";
    }
    @GetMapping("/contact")
    public String getContact(){
        return "/hello";
    }
}
