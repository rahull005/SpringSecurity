package com.basic.Program2_CreatingOwnAuthentication.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class myController {
    @GetMapping("/hello")
    public String get(){
        return "hello";
    }
}
