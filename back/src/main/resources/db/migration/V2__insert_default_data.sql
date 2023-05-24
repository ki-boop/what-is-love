delete
from Roles;
insert into Roles(name)
values ('ROLE_CUSTOMER'),
       ('ROLE_MANAGER');

delete
from Users;
insert into Users(first_name, last_name, username, email)
values ('Test', 'User', 'nxthing', 'test@example.com'),
       ('Олег', 'Иванов', 'customer_1', 'customer1@example.com'),
       ('Геннадий', 'Марков', 'customer_2', 'customer2@example.com'),
       ('Валерий', 'Быков', 'manager_1', 'manager1@example.com'),
       ('Марк', 'Нечаев', 'manager_2', 'manager2@example.com'),
       ('Владимир', 'Котлов', 'manager_3', 'manager3@example.com'),
       ('Дмитрий', 'Козлов', 'manager_4', 'manager4@example.com');

insert into Customer
values (1),
       (2),
       (3);

delete
from Product;
insert into Product(name)
values ('What is Love'),
       ('Насосы'),
       ('Медиагиганты');

insert into Manager
values (4, 1),
       (5, 2),
       (6, 3),
       (7, NULL);

delete
from User_Roles;
insert into User_Roles
values (1, 1),
       (1, 2),
       (1, 3),
       (2, 4),
       (2, 5),
       (2, 6),
       (2, 7);


