CREATE TABLE movie (
    id BIGINT PRIMARY KEY,
    name NVARCHAR(20) NOT NULL,
    release_date DATE NOT NULL,
    UNIQUE (name)
);