COPY title_crew(tconst, directors , writers)
FROM 'C:\\datasets\\title.crew.tsv'
DELIMITER E'\t'
CSV HEADER
NULL '\N';
