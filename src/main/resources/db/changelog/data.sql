INSERT INTO address (id, street, number) VALUES
(UUID_TO_BIN(UUID()), '123 Main St', 100),
(UUID_TO_BIN(UUID()), '456 Elm St', 200);

INSERT INTO authorities (id, authority_Name) VALUES
(UUID_TO_BIN(UUID()), 'ROLE_ADMIN'),
(UUID_TO_BIN(UUID()), 'ROLE_USER');

INSERT INTO roles (id, role_Name) VALUES
(UUID_TO_BIN(UUID()), 'Admin'),
(UUID_TO_BIN(UUID()), 'User');

INSERT INTO builder (id, first_Name, last_name, tell_Number, building_id) VALUES
(UUID_TO_BIN(UUID()), 'Иван', 'Петров', '+1234567890', (SELECT id FROM building WHERE cost = 100000.00)),
(UUID_TO_BIN(UUID()), 'Анна', 'Сидорова', '+9876543210', (SELECT id FROM building WHERE cost = 150000.00));


INSERT INTO owner (id, first_Name, last_name, tell_Number) VALUES
(UUID_TO_BIN(UUID()), 'Alice', 'Johnson', '5551234567'),
(UUID_TO_BIN(UUID()), 'Bob', 'Williams', '5559876543');

INSERT INTO material (id, name, cost) VALUES
(UUID_TO_BIN(UUID()), 'Wood', 50.00),
(UUID_TO_BIN(UUID()), 'Steel', 100.00);

INSERT INTO users (id, login, roles_id) VALUES
(UUID_TO_BIN(UUID()), 'admin', (SELECT id FROM roles WHERE role_Name = 'Admin')),
(UUID_TO_BIN(UUID()), 'user', (SELECT id FROM roles WHERE role_Name = 'User'));

INSERT INTO work_process (id, action, cost, builder_id) VALUES
(UUID_TO_BIN(UUID()), 'Build foundation', 5000.00, (SELECT id FROM builder WHERE first_Name = 'Иван')),
(UUID_TO_BIN(UUID()), 'Install plumbing', 3000.00, (SELECT id FROM builder WHERE first_Name = 'Анна'));

INSERT INTO building (id, address_id, cost, owner_id) VALUES
(UUID_TO_BIN(UUID()), (SELECT id FROM address WHERE street = '123 Main St'), 100000.00, (SELECT id FROM owner WHERE first_Name = 'Alice')),
(UUID_TO_BIN(UUID()), (SELECT id FROM address WHERE street = '456 Elm St'), 150000.00, (SELECT id FROM owner WHERE first_Name = 'Bob'));

INSERT INTO material_quantity (id, building_id, material_id, quantity) VALUES
(UUID_TO_BIN(UUID()), (SELECT id FROM building WHERE cost = 100000.00), (SELECT id FROM material WHERE name = 'Wood'), 500),
(UUID_TO_BIN(UUID()), (SELECT id FROM building WHERE cost = 150000.00), (SELECT id FROM material WHERE name = 'Steel'), 200);
