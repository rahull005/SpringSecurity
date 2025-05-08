package com.Security.UsersFromDatabaseEncryption.Service;
import com.Security.UsersFromDatabaseEncryption.Model.MyUserPrincipal;
import com.Security.UsersFromDatabaseEncryption.Model.User;
import com.Security.UsersFromDatabaseEncryption.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findByUsername(username);
        if(user == null){
            System.out.println("USER NOT FOUND");
            throw new UsernameNotFoundException("USER NOT FOUND");
        }

        return new MyUserPrincipal(user);
    }

}
