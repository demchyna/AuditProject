INSERT INTO roles (id, name) VALUES (1, 'ADMIN');
INSERT INTO roles (id, name) VALUES (2, 'USER');

INSERT INTO users (id, first_name, last_name, email, password, role_id) VALUES (1, 'Yevhen', 'Yevhen', 'yevhen@mail.com', '$2a$10$CdEJ2PKXgUCIwU4pDQWICuiPjxb1lysoX7jrN.Y4MTMoY9pjfPALO', 1);
INSERT INTO users (id, first_name, last_name, email, password, role_id) VALUES (2, 'Mike', 'Green', 'mike@mail.com', '$2a$10$CdEJ2PKXgUCIwU4pDQWICuiPjxb1lysoX7jrN.Y4MTMoY9pjfPALO', 2);


INSERT INTO reports (id, address, energy_efficiency, indicator_1, indicator_2, indicator_3, indicator_4, indicator_5, indicator_6, owner_id) VALUES (1, 'Міцкевича 3', 'G', 123, 134.57, 8.37, 23.310000000000002, 0, 14.469999999999999, 1);