package com.example.construction_project.service.impl;

import com.example.construction_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserService userService;

    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.example.construction_project.entity.User userEntity = userService.findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("User with login " + username + " not found"));

        return new User(userEntity.getLogin(), userEntity.getPassword(),
                List.of(new SimpleGrantedAuthority("ROLE_USER")));
    }
}
