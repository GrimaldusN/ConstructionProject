drop table if exists authorities;

drop table if exists users;

drop table if exists roles;

drop table if exists work_process;

drop table if exists building;

drop table if exists owner;

CREATE TABLE authorities (
    id BIGINT UNSIGNED PRIMARY KEY,
    authority_Name VARCHAR(255) NOT NULL
);

CREATE TABLE roles (
    id BIGINT UNSIGNED PRIMARY KEY,
    role_Name VARCHAR(255)
);


CREATE TABLE owner (
    id BIGINT UNSIGNED PRIMARY KEY,
    first_Name VARCHAR(255),
    last_name VARCHAR(255),
    tell_Number VARCHAR(20)
);

CREATE TABLE users (
    id BIGINT UNSIGNED PRIMARY KEY,
    login VARCHAR(255),
    roles_id BIGINT UNSIGNED,
    FOREIGN KEY (roles_id) REFERENCES roles (id)
);

CREATE TABLE building (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    cost DOUBLE NOT NULL,
    address VARCHAR(255),
    owner_id BIGINT UNSIGNED,
    name VARCHAR(255),
    FOREIGN KEY (owner_id) REFERENCES owner(id)
);

CREATE TABLE work_process (
    id BIGINT UNSIGNED PRIMARY KEY,
    action VARCHAR(255),
    cost DOUBLE,
    builder VARCHAR(255)
);
