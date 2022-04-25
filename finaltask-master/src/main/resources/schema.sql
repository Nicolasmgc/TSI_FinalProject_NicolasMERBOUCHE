DROP TABLE IF EXISTS GAME;
CREATE TABLE GAME (
                      Id INT AUTO_INCREMENT  PRIMARY KEY,
                      Name VARCHAR(50) NOT NULL,
                      Players INT(8) NOT NULL,
                      Price double NOT NULL
);