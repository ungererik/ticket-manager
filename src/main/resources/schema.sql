CREATE TABLE IF NOT EXISTS team (
                                    id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                    name VARCHAR(255) NOT NULL
    );
CREATE TABLE IF NOT EXISTS app_user (
                                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                        username VARCHAR(255) NOT NULL UNIQUE,
    position VARCHAR(255),
    level_of_position VARCHAR(50),
    team_id BIGINT,
    CONSTRAINT fk_user_team FOREIGN KEY (team_id) REFERENCES team(id)
    );


CREATE TABLE IF NOT EXISTS stories (
                                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                       title VARCHAR(255) NOT NULL,
    description VARCHAR(1000),
    status VARCHAR(50) DEFAULT 'PLANNING',
    priority VARCHAR(50),
    deadline DATE,
    assignee_id BIGINT,
    CONSTRAINT fk_story_assignee FOREIGN KEY (assignee_id) REFERENCES app_user(id)
    );