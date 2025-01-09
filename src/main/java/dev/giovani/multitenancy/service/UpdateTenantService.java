package dev.giovani.multitenancy.service;

import dev.giovani.multitenancy.domain.master.Database;
import dev.giovani.multitenancy.domain.master.Schema;
import dev.giovani.multitenancy.domain.master.TenantClient;
import dev.giovani.multitenancy.repository.DatabaseRepository;
import dev.giovani.multitenancy.repository.SchemaRepository;
import dev.giovani.multitenancy.repository.TenantClientRepository;
import lombok.AllArgsConstructor;
import org.flywaydb.core.Flyway;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UpdateTenantService {

    private static final String URL = "jdbc:postgresql://localhost:5432/";
    private static final String USERNAME = "g2dev";
    private static final String PASSWORD = "g2dev-master";

    private TenantClientRepository tenantClientRepository;
    private DatabaseRepository databaseRepository;
    private SchemaRepository schemaRepository;


    public void createDatabases() {
        List<Database> databaseList = databaseRepository.findAllByExecutedFalse();

        if (databaseList.isEmpty()) {
            return;
        }

        final String url = URL + "master";

        JdbcTemplate jdbcTemplate = new JdbcTemplate(
                new DriverManagerDataSource(url, USERNAME, PASSWORD)
        );

        databaseList.forEach(database -> {
            jdbcTemplate.execute("CREATE DATABASE " + database.getName());

            database.setExecuted(true);
            databaseRepository.save(database);
        });

    }

    public void createSchema() {
        List<Schema> schemaList = schemaRepository.findAllByExecutedFalse();

        if (schemaList.isEmpty()) {
            return;
        }

        schemaList.forEach(schema -> {
            final String url = URL + schema.getDatabaseName();
            JdbcTemplate jdbcTemplate = new JdbcTemplate(
                    new DriverManagerDataSource(url, USERNAME, PASSWORD)
            );
            jdbcTemplate.execute("CREATE SCHEMA " + schema.getSchemaName());

            schema.setExecuted(true);
            schemaRepository.save(schema);
        });
    }

    public void updateTenant() {
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
