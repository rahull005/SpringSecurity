package com.Security.UsersFromDatabaseEncryption.Controller;

import com.Security.UsersFromDatabaseEncryption.Model.Student;
import com.Security.UsersFromDatabaseEncryption.Model.User;
import com.Security.UsersFromDatabaseEncryption.Service.AddUserService;
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
    private AddUserService service;
    List<Student> lst = new ArrayList<>(
            Arrays.asList(
                    new Student(1,"rahulll",22),
                    new Student(2,"raghu",21),
                    new Student(3,"Balu",23)
            )
    );

    @GetMapping("/get")
    public List<Student> getStudents(){
        return lst;
    }

    @PostMapping("/post")
    public User addUser(@RequestBody User user){
        return service.addUser(user);
    }
}
