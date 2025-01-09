package dev.giovani.multitenancy.repository;

import dev.giovani.multitenancy.domain.master.TenantClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantClientRepository extends JpaRepository<TenantClient, Long> {

}

