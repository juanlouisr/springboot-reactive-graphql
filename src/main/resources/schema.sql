CREATE TABLE students
(
    id        SERIAL PRIMARY KEY,
    name      VARCHAR(255) NOT NULL,
    school_id SERIAL       NOT NULL
);

CREATE TABLE schools
(
    id        SERIAL PRIMARY KEY,
    name      VARCHAR(255) NOT NULL
);