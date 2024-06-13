drop table if exists buildings;

drop table if exists owners;

drop table if exists role_authority;

drop table if exists authorities;

drop table if exists user_roles;

drop table if exists users;

drop table if exists roles;

drop table if exists work_process;

CREATE TABLE authorities (
    id BINARY(16) PRIMARY KEY,
    authority_Name VARCHAR(255) NOT NULL
);

CREATE TABLE roles (
    id BINARY(16) PRIMARY KEY,
    role_Name VARCHAR(255)
);


CREATE TABLE owners (
    id BINARY(16) PRIMARY KEY,
    first_Name VARCHAR(255),
    last_name VARCHAR(255),
    tell_Number VARCHAR(20)
);

CREATE TABLE users (
    id BINARY(16) PRIMARY KEY,
    login VARCHAR(255),
    password VARCHAR(255),
    roles_id BINARY(16),
    FOREIGN KEY (roles_id) REFERENCES roles (id)
);

CREATE TABLE buildings (
                          id BINARY(16) PRIMARY KEY,
                          address VARCHAR(255) NOT NULL,
                          cost DOUBLE NOT NULL,
                          owner_id BINARY(16),
                          name VARCHAR(255),
                          FOREIGN KEY (owner_id) REFERENCES owners(id)
);

CREATE TABLE work_process (
    id BINARY(16) PRIMARY KEY,
    action VARCHAR(255),
    cost DOUBLE,
    builder VARCHAR(255)
);

CREATE TABLE role_authority (
    role_id BINARY(16),
    authority_id BINARY(16),
    FOREIGN KEY (role_id) REFERENCES roles(id),
    FOREIGN KEY (authority_id) REFERENCES authorities(id),
    PRIMARY KEY (role_id, authority_id)
);

CREATE TABLE user_roles (
    user_id BINARY(16),
    role_id BINARY(16),
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (role_id) REFERENCES roles(id),
    PRIMARY KEY (user_id, role_id)
);