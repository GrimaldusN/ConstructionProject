INSERT INTO address (id, street, number) VALUES
(UUID_TO_BIN(415-425e-4610-87), 'Main St', 10),
(UUID_TO_BIN((2847-702-4602-999-0680258), 'Elm St', 21));

INSERT INTO authorities (id, authority_Name) VALUES
(UUID_TO_BIN(3630618-8660-465-9094-41567620), 'ROLE_ADMIN'),
(UUID_TO_BIN(62086738-7234-480-72-0101726), 'ROLE_USER');

INSERT INTO roles (id, role_Name) VALUES
(UUID_TO_BIN(239376-4062-4499-810-3170246298), 'Admin'),
(UUID_TO_BIN(07944-0-4-672-5883297), 'User');

INSERT INTO builder (id, first_Name, last_name, tell_Number, building_id) VALUES
(UUID_TO_BIN(8304617-80-41-92-884533), 'Иван', 'Петров', '+1234567890', (SELECT id FROM building WHERE cost = 100000.00)),
(UUID_TO_BIN(92687-92e5-41-9-8437851), 'Анна', 'Сидорова', '+9876543210', (SELECT id FROM building WHERE cost = 150000.00));


INSERT INTO owner (id, first_Name, last_name, tell_Number) VALUES
(UUID_TO_BIN(09847-649-4889-891-37885437), 'Alice', 'Johnson', '5551234567'),
(UUID_TO_BIN(440799-15-4921-8-74268688), 'Bob', 'Williams', '5559876543');

INSERT INTO material (id, name, cost) VALUES
(UUID_TO_BIN(72132-577-4097-82-334691220221), 'Wood', 50.00),
(UUID_TO_BIN(332676-12-491-300947484), 'Steel', 100.00);

INSERT INTO users (id, login, roles_id) VALUES
(UUID_TO_BIN(004233-56-447-935-1113584), 'admin', (SELECT id FROM roles WHERE role_Name = 'Admin')),
(UUID_TO_BIN(752-4369-466-13-65710350), 'user', (SELECT id FROM roles WHERE role_Name = 'User'));

INSERT INTO work_process (id, action, cost, builder_id) VALUES
(UUID_TO_BIN(981997-941-499-885-118062), 'Build foundation', 5000.00, (SELECT id FROM builder WHERE first_Name = 'Иван')),
(UUID_TO_BIN(49959-74-4285-93-7e1281818), 'Install plumbing', 3000.00, (SELECT id FROM builder WHERE first_Name = 'Анна'));

INSERT INTO building (id, address_id, cost, owner_id) VALUES
(UUID_TO_BIN(789853-61-407-28856037), (SELECT id FROM address WHERE street = '123 Main St'), 100000.00, (SELECT id FROM owner WHERE first_Name = 'Alice')),
(UUID_TO_BIN(41865-0-4283-9-6973), (SELECT id FROM address WHERE street = '456 Elm St'), 150000.00, (SELECT id FROM owner WHERE first_Name = 'Bob'));

INSERT INTO material_quantity (id, building_id, material_id, quantity) VALUES
(UUID_TO_BIN(62216-2e9-4837-835-95e2243202), (SELECT id FROM building WHERE cost = 100000.00), (SELECT id FROM material WHERE name = 'Wood'), 500),
(UUID_TO_BIN(9816-2624-4013-7-1157), (SELECT id FROM building WHERE cost = 150000.00), (SELECT id FROM material WHERE name = 'Steel'), 200);
