package net.roozbe.imdb.da.repository;

import net.roozbe.imdb.da.entity.RatingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface RatingRepository extends JpaRepository<RatingEntity, String> {

    @Query(value = """
            SELECT 
                DISTINCT ON (t.start_year)
                t.tconst
            FROM 
                titles t
            JOIN 
                ratings r ON t.tconst = r.tconst
            WHERE 
                t.genres ILIKE %:genre%
            ORDER BY 
                t.start_year ASC,
                r.average_rating DESC,
                r.num_votes DESC
            """, nativeQuery = true)
    Set<String> findBestTitlesByGenre(@Param("genre") String genre);
}
