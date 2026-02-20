package com.example.bloggingPlatform.service;

import com.example.bloggingPlatform.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository r;
    public CustomUserDetailsService(UserRepository r) {
        this.r = r;
    }
    @Override
    public UserDetails loadUserByUsername(String u) {
        return r.findByUsername(u).map(user -> org.springframework.security.core.userdetails.User.
                withUsername(user.getUsername()).
                password(user.getPassword()).
                roles("USER").build()).
                orElseThrow(() -> new RuntimeException("Not found"));
    }
}