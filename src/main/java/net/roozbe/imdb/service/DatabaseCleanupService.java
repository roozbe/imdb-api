package net.roozbe.imdb.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
@Slf4j
@AllArgsConstructor
public class DatabaseCleanupService implements CommandLineRunner {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void run(String... args){
        entityManager.createNativeQuery("TRUNCATE TABLE api_logs").executeUpdate();
        log.info("Table api_logs has been cleaned.");
    }
}
