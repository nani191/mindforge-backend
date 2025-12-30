package com.mindforge.backend.service;

import com.mindforge.backend.repository.UserRepository;
import com.mindforge.backend.domain.User;
import com.mindforge.backend.dto.SignupRequest;
import com.mindforge.backend.dto.LoginRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository repo = new UserRepository();
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public String signup(SignupRequest req){
        User user = new User(req.email(), encoder.encode(req.password()));
        repo.save(user);
        return "Signup success";
    }

    public String login(LoginRequest req){
        User user = repo.findByEmail(req.email());
        if(user == null) return "User not found";

        if(!encoder.matches(req.password(), user.getPassword()))
            return "Invalid credentials";

        return "JWT-TOKEN-DUMMY";
    }
}
