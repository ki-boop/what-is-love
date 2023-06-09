CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

drop sequence if exists hibernate_sequence;
create sequence hibernate_sequence;

drop sequence if exists product_seq;
create sequence product_seq;

drop sequence if exists users_seq;
create sequence users_seq;

drop sequence if exists roles_seq;
create sequence roles_seq;

drop type if exists "roleName";
create type "roleName" as enum ('ROLE_CUSTOMER', 'ROLE_MANAGER');

drop table if exists Product;
create table Product
(
    id   bigint default nextval('product_seq') not null,
    name varchar(255)                          not null,
    primary key (id)
);

drop table if exists Users;
create table Users
(
    id         bigint  default NEXTVAL('users_seq') not null,
    first_name varchar(255)                         not null,
    last_name  varchar(255)                         not null,
    username   varchar(255) unique                  not null,
    email      varchar(255) unique                  not null,
    is_active  boolean default true,
    primary key (id)
);

drop table if exists Manager;
create table Manager
(
    id         bigint not null,
    product_id bigint,
    primary key (id),
    foreign key (id) references Users,
    foreign key (product_id) references Product
);

drop table if exists Customer;
create table Customer
(
    id bigint not null,
    primary key (id),
    foreign key (id) references Users
);

drop table if exists Roles;
create table Roles
(
    id   bigint default NEXTVAL('roles_seq') not null,
    name "roleName"                          not null,
    primary key (id)
);

drop table if exists User_roles;
create table User_roles
(
    role_id bigint not null,
    user_id bigint not null,
    foreign key (role_id) references Roles,
    foreign key (user_id) references Users
);

drop table if exists Chat;
create table Chat
(
    id          uuid default uuid_generate_v4() not null,
    customer_id bigint                          not null,
    manager_id  bigint                          not null,
    primary key (id),
    foreign key (customer_id) references Customer,
    foreign key (manager_id) references Manager
);

drop table if exists ChatMessage;
create table ChatMessage
(
    id        uuid default uuid_generate_v4() not null,
    sent_at   date                            not null,
    content   varchar(255)                    not null,
    sender_id bigint                          not null,
    chat_id   uuid                            not null,
    primary key (id),
    foreign key (sender_id) references Users,
    foreign key (chat_id) references Chat
);




