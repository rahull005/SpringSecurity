package com.Security.UsersWithEncryption.Repository;

import com.Security.UsersWithEncryption.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
}
