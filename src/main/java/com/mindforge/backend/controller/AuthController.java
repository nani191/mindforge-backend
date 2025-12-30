package com.mindforge.backend.controller;

import com.mindforge.backend.dto.SignupRequest;
import com.mindforge.backend.dto.LoginRequest;
import com.mindforge.backend.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service){
        this.service = service;
    }

    @PostMapping("/signup")
    public String signup(@RequestBody SignupRequest req){
        return service.signup(req);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest req){
        return service.login(req);
    }
}
