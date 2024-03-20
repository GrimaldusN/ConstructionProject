package com.example._23project.entity;

import java.util.Set;
import java.util.UUID;

public class User {
    private UUID id;
    private String login;
    private Set<Role> roles;
}
