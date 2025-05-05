package com.Security.UsersWithEncryption.Controller;

import com.Security.UsersWithEncryption.Entity.User;
import com.Security.UsersWithEncryption.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @Autowired
    private StudentService service;


    @PostMapping ("/post")
    public User post(@RequestBody User user){
        return service.createUser(user);
    }
}
