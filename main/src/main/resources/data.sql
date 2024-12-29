DELETE FROM comments;
DELETE FROM users;
DELETE FROM categories;
DELETE FROM locations;
DELETE FROM events;

INSERT INTO users (name, email) VALUES ('Petrov', 'petrov@mail.ru');
INSERT INTO users (name, email) VALUES ('Ivanov', 'ivanov@mail.ru');

INSERT INTO categories (name) VALUES ('winter');

INSERT INTO locations (lat, lon) VALUES ('55.732956', '37.507542');

INSERT INTO events (annotation, category_id, created_on, description, event_date, initiator_id, location_id, paid,
                    participant_limit, request_moderation, title)
VALUES ('Водное шоу Кощей', 1, '2021-04-04 09:00:00', 'Сказочное водное шоу для всей семьи',
        '2024-12-31 10:00:00', 2, 1, 'false', 0, 'true', 'Водное шоу Кощей');

INSERT INTO events (annotation, category_id, created_on, description, event_date, initiator_id, location_id, paid,
                    participant_limit, request_moderation, title)
VALUES ('Кот в сапогах', 1, '2021-04-04 10:00:00', 'Премия Звезда Театрала в номинации Лучший спектакль для детей и юношества',
        '2024-12-31 10:00:00', 2, 1, 'false', 0, 'true', 'Кот в сапогах');

UPDATE events SET state = 'PUBLISHED' WHERE id = 1;