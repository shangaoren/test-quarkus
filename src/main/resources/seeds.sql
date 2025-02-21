BEGIN;
INSERT INTO users( id, username, email, password) VALUES (1,'florian', 'florian@owlie.xyz', '$2a$10$qZiZtWlitaCFrbunpJ9caudJlrjAx5UrUzGdJf4H8BNsaTDwCO/be');
INSERT INTO users (id, username, email,password) VALUES (2, 'albert', 'florian+a.nonyme.xyz', '$2a$10$qZiZtWlitaCFrbunpJ9caudJlrjAx5UrUzGdJf4H8BNsaTDwCO/be');
ALTER SEQUENCE users_seq RESTART WITH 3;
COMMIT;