package com.Security.UsersFromDatabaseEncryption.Service;

import com.Security.UsersFromDatabaseEncryption.Model.User;
import com.Security.UsersFromDatabaseEncryption.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AddUserService {
    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    public User addUser(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        return repository.save(user);
    }
}
