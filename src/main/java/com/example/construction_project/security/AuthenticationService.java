package com.example.construction_project.security;

import com.example.construction_project.security.model.JwtAuthenticationResponse;
import com.example.construction_project.security.model.SignInRequest;
import org.springframework.stereotype.Service;

@Service
public interface AuthenticationService  {
    JwtAuthenticationResponse authenticate(SignInRequest request);
}
