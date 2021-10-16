CREATE TABLE genre
(
    id              bigint PRIMARY KEY,
    name            varchar(100) NOT NULL,
    parent_genre_id bigint,
    FOREIGN KEY (parent_genre_id) REFERENCES genre (id)
);

CREATE TABLE track
(
    id   bigint PRIMARY KEY,
    name varchar(100) NOT NULL
);

CREATE TABLE track_genre
(
    track_id bigint,
    genre_id bigint,
    PRIMARY KEY (track_id, genre_id),
    FOREIGN KEY (track_id) REFERENCES track (id),
    FOREIGN KEY (genre_id) REFERENCES genre (id)
);

INSERT INTO genre(id, name, parent_genre_id)
VALUES (1, 'pop', null),
       (2, 'rock', null),
       (3, 'blues', null),
       (4, 'russian pop', 1),
       (5, 'k-pop', 1),
       (6, 'euro pop', 1),
       (7, 'hard rock', 2),
       (8, 'metal', 2),
       (9, 'punk rock', 2),
       (10, 'delta blues', 3),
       (11, 'electric blues', 3),
       (12, 'heavy metal', 8),
       (13, 'trash metal', 8),
       (14, 'post punk', 9),
       (15, 'horror punk', 9);


INSERT INTO track(id, name)
VALUES (1, 'Hallowed Be Thy Name'),
       (2, 'Boys Don''t Cry'),
       (3, 'Riding With The King'),
       (4, 'You Give Love A Bad Name'),
       (5, 'Since I''ve Been Loving You');

INSERT INTO track_genre(track_id, genre_id)
VALUES (1, 12),
       (2, 14),
       (3, 3),
       (4, 2),
       (4, 7),
       (5, 3),
       (5, 7);


with RECURSIVE r as (
    select id as child, id as parent
    from genre

    UNION

    SELECT r.child, edge.parent_genre_id
    from genre as edge
             INNER join r on r.parent = edge.id and not edge.parent_genre_id IS NULL
)

SELECT DISTINCT track.id   as track_id,
                g2.id      as genre_id,
                track.name as track_name,
                g2.name    as genre_name
from track
         INNER join track_genre on track.id = track_genre.track_id
         INNER join r on r.child = track_genre.genre_id
         INNER JOIN genre as g2 ON g2.id = r.parent
order by track.id, g2.id
;



