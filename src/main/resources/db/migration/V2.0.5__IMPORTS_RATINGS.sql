COPY ratings(tconst, average_rating, num_votes)
FROM 'C:\\datasets\\title.ratings.tsv'
DELIMITER E'\t'
CSV HEADER
NULL '\N';
