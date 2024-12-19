package com.example.project2.service;

import com.example.project2.config.AppUserDetails;
import com.example.project2.model.UserModel;
import com.example.project2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserModel> users = userRepository.findByname(username);
        return users.map(AppUserDetails::new).orElseThrow(() -> new UsernameNotFoundException(username + "not found"));
    }
}
