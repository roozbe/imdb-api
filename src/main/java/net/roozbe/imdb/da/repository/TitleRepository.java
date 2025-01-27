package net.roozbe.imdb.da.repository;

import net.roozbe.imdb.da.entity.TitleCrewId;
import net.roozbe.imdb.da.entity.TitleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TitleRepository extends JpaRepository<TitleEntity, TitleCrewId> {
    List<TitleEntity> findByIdInOrderByStartYearAsc(List<TitleCrewId> id);
}
