INSERT INTO author (name)
VALUES ('Jack London'), ('Viola Ardone');

INSERT INTO category (name)
VALUES
    ('Letteratura inglese'),
    ('Novità'),
    ('Best seller');

INSERT INTO book (id, name, fk_author_id, quantity, price)
VALUES
    (gen_random_uuid(), 'Martin Eden', 1, 10, 10.3),
    (gen_random_uuid(), 'Grande Meraviglia', 2, 11, 5),
    (gen_random_uuid(), 'Zanna bianca', 1, 21, 8);

