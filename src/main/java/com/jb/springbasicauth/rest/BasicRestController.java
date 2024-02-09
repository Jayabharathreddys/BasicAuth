package com.jb.springbasicauth.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicRestController {

    @GetMapping("/greet")
    public String greet(){
        return "Hello GREETING Spring security";
    }

    @GetMapping("/contact")
    public String getContact(){
        return "Mobile: 9392015353";
    }

    @GetMapping("/welcome")
    public String getWelcome(){
        return "Hello welcome to Spring security";
    }
}
