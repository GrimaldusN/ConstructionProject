package com.example._23project.entity;

import java.util.Set;
import java.util.UUID;

public class Role {
    UUID id;
    String roleName;
    Set<User> users;
}
