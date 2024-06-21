create table books(
    id bigserial primary key,
    author varchar,
    creation_time timestamp,
    description varchar,
    image varchar,
    price double precision,
    title varchar,
    year int,
    genre_id bigserial references genres(id)
);

insert into books(author, creation_time, description, image, price, title, year, genre_id)
values
('V.G.Sorokin', now(), 'This is a postmodern romance in 2 different times', '313b5e6d-87f1-444f-a37c-b997e9773a66', 420.5, 'Blue lard', 1999, 1),
('V.O.Pelevin', now(), 'This is a novel about a man in a mental hospital. The first book where the action takes place in absolute emptiness',
 '47983802-33f9-4655-bc1e-4e408d700680', 422.5, 'Chapaev and Emptiness', 1997, 4),
('C.M.Palahniuc', now(), 'This is a romance about a porn star who is ending his career', '6fc5002e-8810-48f0-ba81-23dd514d07ab', 327.5, 'Snuff', 2008, 4);