CREATE INDEX idx_titles_tconst ON titles (tconst);

CREATE INDEX idx_ratings_tconst ON ratings (tconst);

CREATE INDEX idx_title_crew_directors_short ON title_crew (left(directors, 255));
CREATE INDEX idx_title_crew_writers_short ON title_crew (left(writers, 255));

CREATE INDEX idx_titles_start_year ON titles (start_year);

CREATE INDEX idx_ratings_avg_rating_votes ON ratings (average_rating, num_votes);

CREATE INDEX idx_names_primary_name ON names (primary_name);
