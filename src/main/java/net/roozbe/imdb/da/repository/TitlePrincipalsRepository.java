package net.roozbe.imdb.da.repository;

import net.roozbe.imdb.da.entity.TitlePrincipalsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TitlePrincipalsRepository extends JpaRepository<TitlePrincipalsEntity, String> {
}
