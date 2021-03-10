package com.codecool.shop.controller;

import com.codecool.shop.model.AuthenticationRequest;
import com.codecool.shop.model.AuthenticationResponse;
import com.codecool.shop.model.User;
import com.codecool.shop.repository.UserRepository;
import com.codecool.shop.service.JwtUtil;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")

public class AuthenticationController {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public AuthenticationController(UserRepository userRepository, AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        try {
            // Authenticate the user
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                authenticationRequest.getUsername(),
                authenticationRequest.getPassword())
            );

            // Create JWT token
            List<String> roles = authentication.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

            final String jwt = jwtUtil.createToken(
                authenticationRequest.getUsername(),
                roles
            );

            // Return Authentication Response model
            User user = userRepository.findByEmail(authenticationRequest.getUsername()).orElseThrow(() -> new UsernameNotFoundException("User not found"));
            return ResponseEntity.ok(new AuthenticationResponse(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                jwt)
            );

        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username/pass", e);
        }

    }
}
