COPY names(nconst, primary_name, birth_year, death_year, primary_profession, known_for_titles)
FROM 'C:\\datasets\\name.basics.tsv'
DELIMITER E'\t'
CSV HEADER
NULL '\N';
