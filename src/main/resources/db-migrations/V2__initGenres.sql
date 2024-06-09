
create table genres(
    id bigserial primary key,
    name varchar(255) unique not null
);

insert into genres(name)
values ('Fantastic'),
       ('Detective'),
        ('Сomic'),
        ('Thriller');