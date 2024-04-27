INSERT INTO authorities (id, authority_Name) VALUES
(1, 'ADMIN'),
(2, 'USER'),
(3, 'GUEST');

INSERT INTO roles (id, role_Name) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER'),
(3, 'ROLE_GUEST');

INSERT INTO owner (id, first_Name, last_name, tell_Number) VALUES
(1, 'John', 'Doe', '123456789'),
(2, 'Jane', 'Smith', '987654321'),
(3, 'Michael', 'Johnson', '456123789');

INSERT INTO users (id, login, roles_id) VALUES
(1, 'john_doe', 1),
(2, 'jane_smith', 2),
(3, 'michael_johnson', 3);

INSERT INTO building (cost, address, owner_id, name) VALUES
(100000.0, '123 Main St', 1, 'Building A'),
(150000.0, '456 Elm St', 2, 'Building B'),
(200000.0, '789 Oak St', 3, 'Building C');

INSERT INTO work_process (id, action, cost, builder) VALUES
(1, 'Foundation', 5000.0, 'John Smith'),
 (2, 'Framing', 8000.0, 'Jane Doe'),
(3, 'Roofing', 6000.0, 'Michael Johnson');
