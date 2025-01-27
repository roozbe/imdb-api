package net.roozbe.imdb.da.repository;

import net.roozbe.imdb.da.entity.ApiLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface ApiLogRepository extends JpaRepository<ApiLogEntity, Long> {
    @Query(value = """
            SELECT 
                T.ENDPOINT,
            	COUNT(*)
            FROM API_LOGS T
            GROUP BY T.ENDPOINT
            """, nativeQuery = true)
    List<Map<String, Long>> countRequests();
}
