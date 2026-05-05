
CREATE TABLE app_user (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          username VARCHAR(255) NOT NULL UNIQUE,
                          position VARCHAR(255),
                          level_of_position VARCHAR(50)
);


CREATE TABLE team (
                      id BIGINT AUTO_INCREMENT PRIMARY KEY,
                      name VARCHAR(255) NOT NULL UNIQUE,
                      user_id BIGINT,
                      CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES app_user(id)
);