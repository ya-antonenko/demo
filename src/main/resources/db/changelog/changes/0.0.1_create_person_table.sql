create table if not exists person
(
    id         BIGINT PRIMARY KEY NOT NULL UNIQUE,
    first_name VARCHAR(255)       NOT NULL,
    last_name  VARCHAR(255)       NOT NULL,
    age        INT,
    sex        VARCHAR(255),
    created    TIMESTAMP          NOT NULL,
    modified   TIMESTAMP          NOT NULL
);