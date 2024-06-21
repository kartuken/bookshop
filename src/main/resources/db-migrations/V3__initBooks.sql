drop table if exists books cascade;
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
('C.M.Palahniuc', now(), 'This is a romance about a porn star who is ending his career', '6fc5002e-8810-48f0-ba81-23dd514d07ab', 327.5, 'Snuff', 2008, 4),
('Liu Qixin', now(),
 'At a time when China was experiencing the consequences of the brutal "cultural revolution",
 signals were sent into space during a secret military project to establish contact with an alien intelligence.
 One of the signals was picked up by a civilization on the verge of destruction, and now the aliens are preparing to invade the Earth.
 Upon learning about this, people were divided into those who are ready to give up our vicious world under the control of a higher mind,
 and those who will fight against this invasion to the last.', 'eff22529-4778-4b2b-9204-ca65b4f3b6ea',
 323.5, 'The task of three bodies', 2006, 1),
('Agatha Christie', now(), 'The elderly and humorless Lady Tressilian invites guests to her Galls Point estate for the summer.
 Among the guests is the famous tennis player Nevil Strange and his second wife. At the same time, Nevilles first wife is also
  visiting the estate. There are many awkward situations because of this neighborhood, but the real trouble begins when Lady
   Tressilian is killed in her sleep. Superintendent Battle, visiting his nephew, Inspector Leach, takes over the investigation.',
        '0498a824-1dc2-444d-86c5-ce4f1f7a4359', 327.5, 'Towards Zero', 1944, 2),
('Wilkie Collins', now(), 'The Hindu god Vishnu commanded that "The Moonstone be guarded by three priests day and night,
 until the end of time and predicted misfortune to anyone who dares to take possession of it. An exciting continuation
 of the story is in the very first and best, according to Thomas Eliot, detective novel of English literature.',
'558fad43-a3b3-4920-9fa5-eda10fdabcaf', 232.5, 'Moonstone', 1866, 2),
('A.S Griboyedov', now(), 'The plot centers on the conflict between the progressive young Alexander Chatsky and the ossified
 secular society of the capital. And although the path to the theater stages was difficult for the play, it instantly diverged
  into quotes that are firmly embedded in our vocabulary.',
 'c63db78a-a27c-4a7f-af6b-18bc63473c55', 144.5, 'Woe from wit', 1825, 3),
('I.A.Ilf and E.P.Petrov', now(), 'Ostap Bender, the Great Schemer, has become a household name, and monuments to him are erected
 throughout Russia. The story of how Bender, together with his “partner” Kisa Vorobyaninov, are trying to find Madame Petukhova’s
  diamonds hidden in one of the 12 chairs of a furniture set, has truly become a “folk classic”.',
 'f49a5ccd-136c-4e13-a45c-0eab7ab3a50b', 127.5, 'The twelve Chairs', 1927, 3);