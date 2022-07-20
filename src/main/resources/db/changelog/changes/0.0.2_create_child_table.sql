create table child (
                       id BIGINT PRIMARY KEY NOT NULL UNIQUE,
                       first_name VARCHAR(255) NOT NULL,
                       last_name VARCHAR(255) NOT NULL,
                       age INT,
                       weight INT,
                       height INT,
                       created TIMESTAMP NOT NULL,
                       modified TIMESTAMP NOT NULL,
                       person_id BIGINT NOT NULL,
                       FOREIGN KEY (person_id) REFERENCES person(id)
);