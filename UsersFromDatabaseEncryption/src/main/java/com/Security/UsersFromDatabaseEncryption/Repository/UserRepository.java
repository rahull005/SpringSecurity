package com.Security.UsersFromDatabaseEncryption.Repository;

import com.Security.UsersFromDatabaseEncryption.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByUsername(String username);
}
