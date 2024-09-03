package com.example.construction_project.security;

import com.example.construction_project.security.model.JwtAuthenticationResponse;
import com.example.construction_project.security.model.SignInRequest;

public interface AuthenticationService  {
    JwtAuthenticationResponse authenticate(SignInRequest request);
}
