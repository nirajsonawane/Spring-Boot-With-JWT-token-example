package com.ns.gwttoken;

import com.ns.gwttoken.entity.User;
import com.ns.gwttoken.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserAuthDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserAuthDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserPrincipal loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println(s);
        User user = userRepository
                .findById(s)
                .orElseThrow(() -> new UsernameNotFoundException("User name " + s + "Not Found in DB"));
        System.out.println(user);
        return UserPrincipal.create(user);

    }
}
