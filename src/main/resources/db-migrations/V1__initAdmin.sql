
create table roles(
    id bigserial primary key,
    name varchar(255) unique not null
);


insert into roles(name)
values ('ROLE_USER'),
       ('ROLE_ADMIN');

create table users(
    id bigserial primary key,
    email varchar(255) unique not null,
    password varchar(255) not null,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    address varchar(255),
);

insert into users(email, password, first_name, last_name, address)
values ('admin@mail.ru', '$2a$10$oCy7SYTnK0rK0caWUcEb1ODJP7oVyx/rNpWjKgJCIGzylSMBW4Gai', 'admin', 'admin', 'admin');

create table user_roles (
    user_id bigserial references users(id),
    role_id bigserial references roles(id)
);

insert into user_roles(user_id, role_id)
values (1, 1),
       (1, 2);