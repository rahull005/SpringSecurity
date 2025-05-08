package com.Security.UsersWithEncryption.Service;

import com.Security.UsersWithEncryption.Entity.User;
import com.Security.UsersWithEncryption.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private UserRepo repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User createUser(User user){
        String pass = passwordEncoder.encode(user.getPassword());  // encode the password
        user.setPassword(pass);
        return repository.save(user);
    }
}

