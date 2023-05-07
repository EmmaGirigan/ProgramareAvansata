revoke usage on schema public from public;
drop table artists;
drop table album_genres;
drop table albums;
drop table genres;

commit;
CREATE TABLE artists (
    id serial PRIMARY KEY,
    name VARCHAR(255)
);

create table albums (
    id serial primary key,
    release_year int,
    name varchar(255),
    artist varchar(255),
    genre varchar(255)
);

create table genres (
    id serial primary key,
    name varchar(255)
);

create table album_genres (
    album_id serial,
    genre_id serial,
    primary key (album_id, genre_id),
    foreign key (album_id) references albums(id),
    foreign key (genre_id) references genres(id)
);
