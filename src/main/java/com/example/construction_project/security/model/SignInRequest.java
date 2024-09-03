package com.example.construction_project.security.model;

import lombok.Data;

@Data
public class SignInRequest {
    private String login;
    private String password;
}
