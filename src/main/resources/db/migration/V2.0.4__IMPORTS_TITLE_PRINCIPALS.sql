COPY title_principals(tconst, ordering, nconst, category, job, characters)
FROM 'C:\\datasets\\title.principals.tsv'
DELIMITER E'\t'
CSV HEADER
NULL '\N';