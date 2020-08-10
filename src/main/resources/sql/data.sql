INSERT INTO user (username, password) VALUES ('John', '$2y$12$UCd5DaSQ.OJ9ogR8iJnnL.6BtUxdNbVMlpgUh/KJQoGpswj0CCwyS');
-- password john1
INSERT INTO user (username, password) VALUES ('Doe', '$2y$12$MmT1dwqa6I1BAx.eeML9UekOJuWzCi3rKMUO3GAJff5HiGwptCWWW');
-- password doe12

INSERT INTO team (id, teamname) VALUES (1, 'Los Angeles Lakers');
INSERT INTO team (id, teamname) VALUES (2, 'Boston Celtics');

INSERT INTO player (id, playername, position, team_id) VALUES (1, 'LeBron James', 'SF / PF', 1);
INSERT INTO player (id, playername, position, team_id) VALUES (2, 'Rajon Rondo', 'PG (Point Guard)', 1);

INSERT INTO player (id, playername, position, team_id) VALUES (3, 'Jaylen Brown', 'SG / SF', 2);
INSERT INTO player (id, playername, position, team_id) VALUES (4, 'Kemba Walker', 'PG (Point Guard)', 2);
