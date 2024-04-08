CREATE TABLE address (
    id BINARY(16) PRIMARY KEY,
    street VARCHAR(255) NOT NULL,
    number DOUBLE NOT NULL
);

CREATE TABLE authorities (
    id BINARY(16) PRIMARY KEY,
    authority_Name VARCHAR(255) NOT NULL
);

CREATE TABLE roles (
    id BINARY(16) PRIMARY KEY,
    role_Name VARCHAR(255)
);

CREATE TABLE builder (
    id BINARY(16) PRIMARY KEY,
    first_Name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    tell_Number VARCHAR(20)
);

CREATE TABLE owner (
    id BINARY(16) PRIMARY KEY,
    first_Name VARCHAR(255),
    last_name VARCHAR(255),
    tell_Number VARCHAR(20)
);

CREATE TABLE material (
    id BINARY(16) PRIMARY KEY,
    name VARCHAR(255),
    cost DOUBLE
);

CREATE TABLE users (
    id BINARY(16) PRIMARY KEY,
    login VARCHAR(255),
    roles_id BINARY(16),
    FOREIGN KEY (roles_id) REFERENCES roles (id)
);

CREATE TABLE work_process (
    id BINARY(16) PRIMARY KEY,
    action VARCHAR(255),
    cost DOUBLE,
    builder_id BINARY(16),
    FOREIGN KEY (builder_id) REFERENCES builder (id)
);
 
 CREATE TABLE building (
    id BINARY(16) PRIMARY KEY,
    address_id BINARY(16) NOT NULL,
    cost DOUBLE NOT NULL,
    owner_id BINARY(16),
    FOREIGN KEY (address_id) REFERENCES address(id),
    FOREIGN KEY (owner_id) REFERENCES owner(id)
);

CREATE TABLE material_quantity (
    id BINARY(16) PRIMARY KEY,
    building_id BINARY(16) NOT NULL,
    material_id BINARY(16) NOT NULL,
    quantity INT NOT NULL,
    FOREIGN KEY (building_id) REFERENCES building(id),
    FOREIGN KEY (material_id) REFERENCES material(id)
);
