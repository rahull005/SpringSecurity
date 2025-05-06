package com.Security.JWT.Repository;

import com.Security.JWT.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Integer> {
    Users findByusername(String username);
}
