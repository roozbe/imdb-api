package net.roozbe.imdb.da.repository;

import net.roozbe.imdb.da.entity.TitleCrewEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TitleCrewRepository extends JpaRepository<TitleCrewEntity, String> {

    @Query("SELECT tc FROM TitleCrewEntity tc , NameEntity  n WHERE tc.directors = tc.writers and n.deathYear <= :currentYear")
    List<TitleCrewEntity> findTitlesWithSameDirectorAndWriterAlive(Integer currentYear, Pageable pageable);
}
