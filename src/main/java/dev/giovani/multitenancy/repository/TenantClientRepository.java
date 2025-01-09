package dev.giovani.multitenancy.repository;

import dev.giovani.multitenancy.domain.master.TenantClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TenantClientRepository extends JpaRepository<TenantClient, Long> {

}

