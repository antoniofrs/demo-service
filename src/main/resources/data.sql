INSERT INTO author (name)
VALUES ('Jack London'), ('Viola Ardone');

INSERT INTO book (id, name, fk_author_id, quantity, price)
VALUES (gen_random_uuid(), 'Martin Eden', 2, 110, 5),
        (gen_random_uuid(), 'Grande Meraviglia', 3, 115, 6);