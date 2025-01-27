CREATE TABLE names
(
    nconst             VARCHAR PRIMARY KEY,
    primary_name       VARCHAR(255),
    birth_year         INT,
    death_year         INT,
    primary_profession VARCHAR(255),
    known_for_titles   VARCHAR
);


CREATE TABLE titles
(
    tconst          VARCHAR PRIMARY KEY,
    title_type      VARCHAR(50),
    primary_title   VARCHAR(2000),
    original_title  VARCHAR(2000),
    is_adult        BOOLEAN DEFAULT FALSE,
    start_year      INT,
    end_year        INT,
    runtime_minutes INT,
    genres          VARCHAR(255)
);


CREATE TABLE title_crew
(
    tconst VARCHAR REFERENCES titles (tconst) ON DELETE CASCADE,
    directors VARCHAR,
    writers VARCHAR
);


CREATE TABLE title_principals
(
    tconst     VARCHAR REFERENCES titles (tconst) ON DELETE CASCADE,
    ordering   INT,
    nconst     VARCHAR,
    category   VARCHAR,
    job        VARCHAR,
    characters TEXT
);


CREATE TABLE ratings
(
    tconst         VARCHAR PRIMARY KEY REFERENCES titles (tconst) ON DELETE CASCADE,
    average_rating DECIMAL(3, 1),
    num_votes      INT
);
