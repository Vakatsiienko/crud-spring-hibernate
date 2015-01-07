CREATE TABLE user
(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    createdDate DATETIME,
    age INT NOT NULL,
    name VARCHAR(255),
    admin BIT NOT NULL
);
INSERT INTO test.user (id, createdDate, age, name, admin) VALUES (1, '2015-01-07 21:58:24', 12, 'user1', false);
INSERT INTO test.user (id, createdDate, age, name, admin) VALUES (2, '2015-01-07 21:58:37', 13, 'user2', false);
INSERT INTO test.user (id, createdDate, age, name, admin) VALUES (3, '2015-01-07 21:58:48', 15, 'user3', false);
INSERT INTO test.user (id, createdDate, age, name, admin) VALUES (4, '2015-01-07 21:58:56', 123, 'user11', false);
INSERT INTO test.user (id, createdDate, age, name, admin) VALUES (5, '2015-01-07 21:59:04', 66, 'user53', false);
INSERT INTO test.user (id, createdDate, age, name, admin) VALUES (6, '2015-01-07 21:59:12', 44, 'user12', false);
INSERT INTO test.user (id, createdDate, age, name, admin) VALUES (7, '2015-01-07 21:59:21', 53, 'user55', false);
INSERT INTO test.user (id, createdDate, age, name, admin) VALUES (8, '2015-01-07 21:59:28', 55, 'user77', false);
INSERT INTO test.user (id, createdDate, age, name, admin) VALUES (9, '2015-01-07 21:59:35', 43, 'user43', false);
INSERT INTO test.user (id, createdDate, age, name, admin) VALUES (10, '2015-01-07 21:59:41', 88, 'user88', false);
INSERT INTO test.user (id, createdDate, age, name, admin) VALUES (11, '2015-01-07 21:59:47', 12, 'userus', false);
INSERT INTO test.user (id, createdDate, age, name, admin) VALUES (12, '2015-01-07 21:59:57', 11, 'userus14', false);