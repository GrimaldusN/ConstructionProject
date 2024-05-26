
INSERT INTO authorities (id, authority_Name) VALUES
                                                 (UUID_TO_BIN('f47ac10b-58cc-4372-a567-0e02b2c3d479'), 'ADMIN'),
                                                 (UUID_TO_BIN('23ad7e4b-42f7-4cf5-a8f0-4a3e4b0aaf10'), 'USER'),
                                                 (UUID_TO_BIN('1b67323d-9bf5-4a4b-99ba-8a8d45358d6b'), 'GUEST');

INSERT INTO roles (id, role_Name) VALUES
                                      (UUID_TO_BIN('aa1ecdd8-0e4f-4db2-822b-813bf5677090'), 'ROLE_ADMIN'),
                                      (UUID_TO_BIN('7e37b4f3-1f29-4ef6-bb58-dbbd30352e4d'), 'ROLE_USER'),
                                      (UUID_TO_BIN('e3da7abf-716e-4f93-8ad0-912fd6ba62e6'), 'ROLE_GUEST');

INSERT INTO owner (id, first_Name, last_name, tell_Number) VALUES
                                                               (UUID_TO_BIN('2bcf850c-8e34-4f85-8f5f-f0cf86a5b482'), 'John', 'Doe', '123456789'),
                                                               (UUID_TO_BIN('89a798b8-460d-4421-8fd6-9b7816e7e7e9'), 'Jane', 'Smith', '987654321'),
                                                               (UUID_TO_BIN('2c5c6485-0df6-42ab-9d21-5de7b19e7905'), 'Michael', 'Johnson', '456123789');

INSERT INTO users (id, login) VALUES
                                  (UUID_TO_BIN('aa0e63f5-2e36-4f49-8d47-1c56f99d4b9a'), 'john_doe'),
                                  (UUID_TO_BIN('d62a0a7d-5b2c-4edb-9a61-df8c15f5b83d'), 'jane_smith'),
                                  (UUID_TO_BIN('f3e8ab73-688c-4f8f-91e7-3ba1c1cf4776'), 'michael_johnson');

INSERT INTO building (id,cost, address, owner_id, name) VALUES
                                                            (UUID_TO_BIN('4a3f12b8-6e37-45cb-8d6e-0b07a5c39c6e'), 100000.0, '123 Main St', UUID_TO_BIN('2bcf850c-8e34-4f85-8f5f-f0cf86a5b482'), 'Building A'),
                                                            (UUID_TO_BIN('9e2f2563-2df3-4f84-95f1-74c5b4e0b26e'), 150000.0, '456 Elm St', UUID_TO_BIN('89a798b8-460d-4421-8fd6-9b7816e7e7e9'), 'Building B'),
                                                            (UUID_TO_BIN('b4166f59-8b4f-4e8a-b77a-21ec0144a8a7'), 200000.0, '789 Oak St', UUID_TO_BIN('2c5c6485-0df6-42ab-9d21-5de7b19e7905'), 'Building C');

INSERT INTO work_process (id, action, cost, builder) VALUES
                                                         (UUID_TO_BIN('7d9d9334-4b0a-4f87-9e30-63e780f5079d'), 'Foundation', 5000.0, 'John Smith'),
                                                         (UUID_TO_BIN('e92f5b99-6b2d-4d3e-9ef9-36b8237b7a35'), 'Framing', 8000.0, 'Jane Doe'),
                                                         (UUID_TO_BIN('a5f56c7d-7f8a-409f-a7c6-53cba44f4473'), 'Roofing', 6000.0, 'Michael Johnson');

INSERT INTO user_roles(user_id, role_id) VALUES
                                             (UUID_TO_BIN('aa0e63f5-2e36-4f49-8d47-1c56f99d4b9a'), UUID_TO_BIN('e3da7abf-716e-4f93-8ad0-912fd6ba62e6')),
                                             (UUID_TO_BIN('d62a0a7d-5b2c-4edb-9a61-df8c15f5b83d'), UUID_TO_BIN('7e37b4f3-1f29-4ef6-bb58-dbbd30352e4d')),
                                             (UUID_TO_BIN('f3e8ab73-688c-4f8f-91e7-3ba1c1cf4776'), UUID_TO_BIN('aa1ecdd8-0e4f-4db2-822b-813bf5677090'));

INSERT INTO role_authority(role_id, authority_id) VALUES
                                                      (UUID_TO_BIN('aa1ecdd8-0e4f-4db2-822b-813bf5677090'), UUID_TO_BIN('f47ac10b-58cc-4372-a567-0e02b2c3d479')),
                                                      (UUID_TO_BIN('7e37b4f3-1f29-4ef6-bb58-dbbd30352e4d'), UUID_TO_BIN('23ad7e4b-42f7-4cf5-a8f0-4a3e4b0aaf10')),
                                                      (UUID_TO_BIN('e3da7abf-716e-4f93-8ad0-912fd6ba62e6'), UUID_TO_BIN('1b67323d-9bf5-4a4b-99ba-8a8d45358d6b'));