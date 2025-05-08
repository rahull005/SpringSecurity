package com.Security.RoleBasedAuthorization.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/user")
    @PreAuthorize("hasUser('USER')")
    public String user(){
        return "hello,User";
    }


    @PreAuthorize("hasUser('ADMIN')")
    @GetMapping("/admin")
    public String admin(){
        return "hello,admin";
    }
}
