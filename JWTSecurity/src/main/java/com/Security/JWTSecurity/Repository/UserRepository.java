package com.Security.JWTSecurity.Repository;

import com.Security.JWTSecurity.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
