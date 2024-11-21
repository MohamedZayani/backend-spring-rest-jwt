package dev.rest.jwt.controller;

import dev.rest.jwt.security.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam("username") String username, @RequestParam("password") String password) {
        // Authentification basique (à remplacer par un vrai service)
        if ("admin".equals(username) && "123".equals(password)) {
            String token = jwtUtil.generateToken(username, List.of("ADMIN"));
            return ResponseEntity.ok(token);
        } else if ("user".equals(username) && "123".equals(password)) {
            String token = jwtUtil.generateToken(username, List.of("USER"));
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }
}

