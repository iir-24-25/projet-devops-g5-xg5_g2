package org.example.gestion_stock.controller;

import org.example.gestion_stock.dto.AuthRequest;
import org.example.gestion_stock.dto.AuthResponse;
import org.example.gestion_stock.dto.RegisterRequest;
import org.example.gestion_stock.model.User;
import org.example.gestion_stock.repository.UserRepository;
import org.example.gestion_stock.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;
    @Autowired private JwtService jwtService;
    @Autowired private UserRepository userRepo;
    @Autowired private PasswordEncoder encoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        try {
            authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );

            var user = userRepo.findByUsername(request.getUsername()).orElseThrow();
            String token = jwtService.generateToken(user.getUsername());

            return ResponseEntity.ok(new AuthResponse(token));
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Collections.singletonMap("error", "Invalid credentials"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonMap("error", "Login failed"));
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        try {
            if (userRepo.existsByUsername(request.getUsername())) {
                return ResponseEntity.badRequest()
                        .body(Collections.singletonMap("error", "Username already exists"));
            }

            if (userRepo.existsByEmail(request.getEmail())) {
                return ResponseEntity.badRequest()
                        .body(Collections.singletonMap("error", "Email already exists"));
            }

            User user = new User();
            user.setUsername(request.getUsername());
            user.setPasswordHash(encoder.encode(request.getPassword()));
            user.setEmail(request.getEmail());
            user.setRole(request.getRole());

            userRepo.save(user);
            return ResponseEntity.ok(Collections.singletonMap("message", "User registered successfully"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonMap("error", "Registration failed"));
        }
    }
}
