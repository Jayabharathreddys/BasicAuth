package com.jb.springbasicauth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicRestController {

    @GetMapping("/msg")
    public String getMsg(){
        return "Hello welcome to Spring security";
    }
}
