//package dev.giovani.multitenancy.config;
//
//import com.zaxxer.hikari.HikariDataSource;
//import jakarta.annotation.PostConstruct;
//import org.flywaydb.core.Flyway;
//import org.springframework.context.annotation.Configuration;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.nio.file.Paths;
//import java.util.Properties;
//
//@Configuration
//public class FlywayConfig {
//
//    @PostConstruct
//    public void migrate() {
//
//        File[] files = Paths.get("allTenants").toFile().listFiles();
//
//        for (File propertyFile : files) {
//            Properties tenantProperties = new Properties();
//            String tenantId = null;
//            try {
//                tenantProperties.load(new FileInputStream(propertyFile));
//                tenantId = tenantProperties.getProperty("name");
//
//                String driverClassName = tenantProperties.getProperty("driver-class-name");
//                String url = tenantProperties.getProperty("url");
//                String username = tenantProperties.getProperty("username");
//                String password = tenantProperties.getProperty("password");
//
//                Flyway flyway = Flyway.configure()
//                        .dataSource(url, username, password)
//                        .locations("classpath:db/migration/") // Migrações específicas por tenant (opcional)
//                        .baselineOnMigrate(true)
//                        .load();
//                flyway.migrate();
//
//            } catch (Exception e) {
//                throw new RuntimeException("Problem in update tenant:" + tenantId  + " - " + e);
//            }
//        }
//    }
//}
