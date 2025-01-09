package dev.giovani.multitenancy.service;

import dev.giovani.multitenancy.domain.master.TenantClient;
import dev.giovani.multitenancy.repository.TenantClientRepository;
import lombok.AllArgsConstructor;
import org.flywaydb.core.Flyway;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UpdateTenantService {

    private TenantClientRepository tenantClientRepository;

    public void execute() {

        List<TenantClient> tenantClientList = tenantClientRepository.findAll();

        if (tenantClientList.isEmpty()) {
            return;
        }

        tenantClientList.forEach(tenantClient -> {
            System.out.println("Update tenant: " + tenantClient.toString());

            Flyway flyway = Flyway.configure()
                    .dataSource(tenantClient.getUrl(), tenantClient.getUsername(), tenantClient.getPassword())
                    .locations("classpath:db/migration/tenant")
                    .schemas(tenantClient.getSchemaName())
                    .baselineOnMigrate(true)
                    .load();
            flyway.migrate();
        });

    }

}
