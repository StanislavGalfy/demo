DROP TABLE IF EXISTS demo;

CREATE TABLE demo (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(250) UNIQUE NOT NULL
);