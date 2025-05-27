package com.Security.JWTSecurity.Service;

import com.Security.JWTSecurity.Model.Users;
import com.Security.JWTSecurity.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         UserDetailImp user = repo.findByUsername(username)
                .map(users -> new UserDetailImp(users))
                .orElseThrow(() -> new UsernameNotFoundException("user not found"));
    return user;
    }
}
