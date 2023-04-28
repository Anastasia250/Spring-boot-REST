INSERT INTO roles (name) VALUES ('ADMIN');
INSERT INTO roles (name) VALUES ('USER');
INSERT INTO users (age, email, first_name, last_name, password) VALUES (20, 'admin@test.com', 'Tom', 'Jones', 'admin');
INSERT INTO users (age, email, first_name, last_name, password) VALUES (21, 'user@test.com', 'Bob', 'Brown', 'user');
INSERT INTO users_roles (user_id, roles_id) VALUES (1, 1);
INSERT INTO users_roles (user_id, roles_id) VALUES (1, 2);
INSERT INTO users_roles (user_id, roles_id) VALUES (2, 2);