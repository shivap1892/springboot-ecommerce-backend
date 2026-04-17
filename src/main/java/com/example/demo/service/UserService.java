package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    // Register
    public User register(User user){
        user.setPassword(encoder.encode(user.getPassword())); // 🔥 encryption
        return repo.save(user);
    }

    // Login
    public Optional<User> login(String username, String password){
        Optional<User> user = repo.findByUsername(username);

        if(user.isPresent() && encoder.matches(password, user.get().getPassword())){
            return user;
        }
        return Optional.empty();
    }
}