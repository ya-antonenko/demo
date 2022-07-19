# demo project

Project to improve Kotlin skills

Frameworks that are used:

* Main:
    * Kotlin
    * Spring Web (REST)
    * Spring Data (Hibernate)
* Database:
    * MySQL
* Test:
    * JUnit 5
* Additional:
    * Lombok

SQL query to create tables:

>*create table person (\
id BIGINT PRIMARY KEY NOT NULL UNIQUE,\
first_name VARCHAR(255) NOT NULL,\
last_name VARCHAR(255) NOT NULL,\
age INT,\
sex VARCHAR(255),\
created DATETIME NOT NULL,\
modified DATETIME NOT NULL\
);*

>*create table child (\
id BIGINT PRIMARY KEY NOT NULL UNIQUE,\
first_name VARCHAR(255) NOT NULL,\
last_name VARCHAR(255) NOT NULL,\
age INT,\
weight INT,\
height INT,\
created DATETIME NOT NULL,\
modified DATETIME NOT NULL,\
person_id BIGINT NOT NULL,\
FOREIGN KEY (person_id) REFERENCES person(id)\
);*