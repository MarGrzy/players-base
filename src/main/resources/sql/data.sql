INSERT INTO user (username, password) VALUES ('John', '$2y$12$/26nHyO75eG0ShuoTotChuGC/TgZe3BJJu3D89UFmzWYhJrRxSbEi');
-- password john
INSERT INTO user (username, password) VALUES ('Doe', '$2y$12$k2Z.jrMWTsCwPD5tT.1m5eFRtnBRCMTnSQVrKjPG9gJ6LyCpqXMzS');
-- password doe

INSERT INTO team (id, teamname) VALUES (1, 'Los Angeles Lakers');
INSERT INTO team (id, teamname) VALUES (2, 'Boston Celtics');

INSERT INTO player (id, name, position, team_id) VALUES (1, 'LeBron James', 'SF / PF', 1);
INSERT INTO player (id, name, position, team_id) VALUES (2, 'Rajon Rondo', 'PG', 1);

INSERT INTO player (id, name, position, team_id) VALUES (3, 'Jaylen Brown', 'PG / SF', 2);
INSERT INTO player (id, name, position, team_id) VALUES (4, 'Kemba Walker', 'PG', 2);
