package net.roozbe.imdb.da.repository;

import net.roozbe.imdb.da.entity.NameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NameRepository extends JpaRepository<NameEntity, String> {

    List<NameEntity> findByPrimaryNameIn(List<String> names);
}
