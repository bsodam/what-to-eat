CREATE TABLE users (username VARCHAR(100) NOT NULL PRIMARY KEY, encoded_password VARCHAR(255));
INSERT INTO users (username, encoded_password) VALUES ('user1', '$2a$10$1gJJgBlL75OIjkSgkYPXI.mV7ihEPjxIiCkXKBEc7/r9xUIjZyc9i' /*demo*/);
INSERT INTO users (username, encoded_password) VALUES ('user2', '$2a$10$1gJJgBlL75OIjkSgkYPXI.mV7ihEPjxIiCkXKBEc7/r9xUIjZyc9i' /*demo*/);
ALTER TABLE restaurants ADD username VARCHAR(100) NOT NULL DEFAULT 'user1';
ALTER TABLE restaurants ADD CONSTRAINT FK_RESTAURANTS_USERNAME FOREIGN KEY (username) REFERENCES users;