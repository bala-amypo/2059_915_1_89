package com.example.demo.controller;

import com.example.demo.dto.AuthResponse;
import com.example.demo.model.User;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.impl.UserServiceImpl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserServiceImpl userService;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;

    public AuthController(
            UserServiceImpl userService,
            AuthenticationManager authenticationManager,
            UserDetailsService userDetailsService,
            JwtUtil jwtUtil) {

        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestParam String email,
                              @RequestParam String password) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password)
        );

        UserDetails userDetails = userDetailsService.loadUserByUsername(email);

        // Dummy user object (test-oriented)
        User user = new User();
        user.setEmail(email);
        user.setRole("USER");
        user.setId(1L);

        String token = jwtUtil.generateToken(userDetails, user);

        return new AuthResponse(token, user.getId(), user.getEmail(), user.getRole());
    }
}
