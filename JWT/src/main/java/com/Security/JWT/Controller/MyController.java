package com.Security.JWT.Controller;

import com.Security.JWT.Model.Student;
import com.Security.JWT.Model.Users;
import com.Security.JWT.Service.MyUserService;
import com.Security.JWT.Service.UserAddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class MyController {
    @Autowired
    private UserAddService service;


    List<Student> students = new ArrayList<>(
            Arrays.asList(
                    new Student(1,"rahul",21),
                    new Student(2,"balu",22)
            )
    );

    @GetMapping("/get")
    public List<Student> getStudents(){
        return students;
    }


    @PostMapping("/add")
    public Users addUser(@RequestBody Users users){
        return service.addUser(users);
    }

    @GetMapping("/login")
    public String login(@RequestBody Users user){
        return service.verify(user);
    }
}
