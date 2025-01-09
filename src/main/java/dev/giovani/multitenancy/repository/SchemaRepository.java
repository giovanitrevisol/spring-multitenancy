package dev.giovani.multitenancy.repository;

import dev.giovani.multitenancy.domain.master.Schema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SchemaRepository extends JpaRepository<Schema, Long> {

    List<Schema> findAllByExecutedFalse();

}
