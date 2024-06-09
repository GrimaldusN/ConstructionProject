INSERT INTO authorities (id, authority_Name) VALUES
(UUID_TO_BIN('4a3f12b8-6e37-45cb-8d6e-0b07a5c39c6e'), 'CREATE'),
(UUID_TO_BIN('9e2f2563-2df3-4f84-95f1-74c5b4e0b26e'), 'READ'),
(UUID_TO_BIN('b4166f59-8b4f-4e8a-b77a-21ec0144a8a7'), 'UPDATE'),
(UUID_TO_BIN('7d9d9334-4b0a-4f87-9e30-63e780f5079d'), 'DELETE');

INSERT INTO owners (id, first_Name, last_name, tell_Number) VALUES
(UUID_TO_BIN('4a3f12b8-6e37-45cb-8d6e-0b07a5c39c6e'), 'Alice', 'Johnson', '5551234567'),
(UUID_TO_BIN('aa0e63f5-2e36-4f49-8d47-1c56f99d4b9a'), 'Bob', 'Williams', '5559876543'),
(UUID_TO_BIN('2c5c6485-0df6-42ab-9d21-5de7b19e7905'), 'John', 'Doe', '1234567890'),
(UUID_TO_BIN('89a798b8-460d-4421-8fd6-9b7816e7e7e9'), 'Emma', 'Brown', '9999999999');

INSERT INTO roles (id, role_Name) VALUES
(UUID_TO_BIN('e92f5b99-6b2d-4d3e-9ef9-36b8237b7a35'), 'ROLE_ADMIN'),
(UUID_TO_BIN('a5f56c7d-7f8a-409f-a7c6-53cba44f4473'), 'ROLE_USER'),
(UUID_TO_BIN('b4166f59-8b4f-4e8a-b77a-21ec0144a8a7'), 'ROLE_MANAGER'),
(UUID_TO_BIN('9e2f2563-2df3-4f84-95f1-74c5b4e0b26e'), 'ROLE_GUEST');

INSERT INTO users (id, login, roles_id) VALUES
(UUID_TO_BIN('2bcf850c-8e34-4f85-8f5f-f0cf86a5b482'), 'admin', (SELECT id FROM roles WHERE role_Name = 'ROLE_ADMIN')),
(UUID_TO_BIN('e3da7abf-716e-4f93-8ad0-912fd6ba62e6'), 'user', (SELECT id FROM roles WHERE role_Name = 'ROLE_USER')),
(UUID_TO_BIN('7e37b4f3-1f29-4ef6-bb58-dbbd30352e4d'), 'manager', (SELECT id FROM roles WHERE role_Name = 'ROLE_MANAGER')),
(UUID_TO_BIN('aa1ecdd8-0e4f-4db2-822b-813bf5677090'), 'guest', (SELECT id FROM roles WHERE role_Name = 'ROLE_GUEST'));

INSERT INTO work_process (id, action, cost, builder) VALUES
(UUID_TO_BIN('1b67323d-9bf5-4a4b-99ba-8a8d45358d6b'), 'Build foundation', 5000.00, 'Ivan'),
(UUID_TO_BIN('23ad7e4b-42f7-4cf5-a8f0-4a3e4b0aaf10'), 'Install plumbing', 3000.00, 'Anna');

INSERT INTO buildings (id, address, cost, owner_id) VALUES
(UUID_TO_BIN('f47ac10b-58cc-4372-a567-0e02b2c3d479'),'123 Main St', 100000.00, (SELECT id FROM owners WHERE first_Name = 'Alice')),
(UUID_TO_BIN('a4e0d47d-ee3d-4a35-b7a2-0f39f1d56a30'),'456 Elm St', 150000.00, (SELECT id FROM owners WHERE first_Name = 'John')),
(UUID_TO_BIN('59b2af08-b6d3-4b0b-a3d9-fb7f29528295'),'789 Oak St', 200000, (SELECT id FROM owners WHERE first_Name = 'Bob' )),
(UUID_TO_BIN('fbbfb5c7-bcd8-4826-bf7a-6328831347cb'),'1011 Pine St', 250000, (SELECT id FROM owners WHERE first_Name = 'Emma' ));

INSERT INTO role_authority (authority_id, role_id) VALUES
(UUID_TO_BIN('4a3f12b8-6e37-45cb-8d6e-0b07a5c39c6e'), UUID_TO_BIN('e92f5b99-6b2d-4d3e-9ef9-36b8237b7a35')),
(UUID_TO_BIN('9e2f2563-2df3-4f84-95f1-74c5b4e0b26e'), UUID_TO_BIN('e92f5b99-6b2d-4d3e-9ef9-36b8237b7a35')),
(UUID_TO_BIN('b4166f59-8b4f-4e8a-b77a-21ec0144a8a7'), UUID_TO_BIN('e92f5b99-6b2d-4d3e-9ef9-36b8237b7a35')),
(UUID_TO_BIN('7d9d9334-4b0a-4f87-9e30-63e780f5079d'), UUID_TO_BIN('e92f5b99-6b2d-4d3e-9ef9-36b8237b7a35')),
(UUID_TO_BIN('9e2f2563-2df3-4f84-95f1-74c5b4e0b26e'), UUID_TO_BIN('a5f56c7d-7f8a-409f-a7c6-53cba44f4473')),
(UUID_TO_BIN('7d9d9334-4b0a-4f87-9e30-63e780f5079d'), UUID_TO_BIN('a5f56c7d-7f8a-409f-a7c6-53cba44f4473')),
(UUID_TO_BIN('9e2f2563-2df3-4f84-95f1-74c5b4e0b26e'), UUID_TO_BIN('b4166f59-8b4f-4e8a-b77a-21ec0144a8a7')),
(UUID_TO_BIN('7d9d9334-4b0a-4f87-9e30-63e780f5079d'), UUID_TO_BIN('b4166f59-8b4f-4e8a-b77a-21ec0144a8a7')),
(UUID_TO_BIN('b4166f59-8b4f-4e8a-b77a-21ec0144a8a7'), UUID_TO_BIN('b4166f59-8b4f-4e8a-b77a-21ec0144a8a7')),
(UUID_TO_BIN('9e2f2563-2df3-4f84-95f1-74c5b4e0b26e'), UUID_TO_BIN('9e2f2563-2df3-4f84-95f1-74c5b4e0b26e'));

INSERT INTO user_roles(user_id, role_id) VALUES
(UUID_TO_BIN('2bcf850c-8e34-4f85-8f5f-f0cf86a5b482'), UUID_TO_BIN('e92f5b99-6b2d-4d3e-9ef9-36b8237b7a35')),
(UUID_TO_BIN('e3da7abf-716e-4f93-8ad0-912fd6ba62e6'), UUID_TO_BIN('a5f56c7d-7f8a-409f-a7c6-53cba44f4473')),
(UUID_TO_BIN('7e37b4f3-1f29-4ef6-bb58-dbbd30352e4d'), UUID_TO_BIN('b4166f59-8b4f-4e8a-b77a-21ec0144a8a7')),
(UUID_TO_BIN('aa1ecdd8-0e4f-4db2-822b-813bf5677090'), UUID_TO_BIN('9e2f2563-2df3-4f84-95f1-74c5b4e0b26e'));