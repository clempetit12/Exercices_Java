INSERT INTO user (name, email, is_enabled, password, role_id)
VALUES ('John Doe', 'john.doe@example.com', 1, 'password123', 1);
INSERT INTO role (role)
VALUES ('ROLE_USER'),
       ('ROLE_ADMIN');
       
INSERT INTO tasks (name, description, priority, ending_date, creation_date, status,user_id)
VALUES ('Tâche 2', 'Description de la tâche 2', 1, '2022-12-31', '2022-03-28', true,1);

select * from role;
select * from user;
select * from tasks;
select * from user;