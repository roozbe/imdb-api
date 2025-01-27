COPY titles(tconst, title_type, primary_title, original_title, is_adult, start_year, end_year, runtime_minutes, genres)
FROM 'C:\\datasets\\title.basics.tsv'
DELIMITER E'\t'
CSV HEADER
NULL '\N';
