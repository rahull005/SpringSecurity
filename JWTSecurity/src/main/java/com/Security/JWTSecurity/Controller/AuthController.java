package com.Security.JWTSecurity.Controller;

import com.Security.JWTSecurity.Model.AuthRequest;
import com.Security.JWTSecurity.Model.Users;
import com.Security.JWTSecurity.Repository.UserRepository;
import com.Security.JWTSecurity.Service.CustomUserDetailsService;
import com.Security.JWTSecurity.Service.JwtUtil;
import com.Security.JWTSecurity.Service.UserDetailImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired private AuthenticationManager authManager;
    @Autowired private JwtUtil jwtUtil;
    @Autowired private UserRepository repo;
    @Autowired private PasswordEncoder encoder;
    @Autowired private CustomUserDetailsService service;

    @PostMapping("/register")
    public String register(@RequestBody Users user) {
        user.setPassword(encoder.encode(user.getPassword()));
        repo.save(user);
        return "User registered";
    }

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest request) {
//        UserDetails u = service.loadUserByUsername(request.getUsername());
        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        return jwtUtil.generateToken(request.getUsername());
    }
}


