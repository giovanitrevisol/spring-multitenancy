//package dev.giovani.multitenancy.config;
//
//import com.zaxxer.hikari.HikariDataSource;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
//
//import javax.sql.DataSource;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.nio.file.Paths;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Properties;
//
//
//@Configuration
//public class MultitenantConfiguration {
//
//    @Value("${defaultTenant}")
//    private String defaultTenant;
//
//    @Bean
//    @ConfigurationProperties(prefix = "tenants")
//    public DataSource dataSource() {
//
//        File[] files = Paths.get("allTenants").toFile().listFiles();
//        Map<Object, Object> resolvedDataSources = new HashMap<>();
//
//        for (File propertyFile : files) {
//            Properties tenantProperties = new Properties();
////            DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//            try {
//                tenantProperties.load(new FileInputStream(propertyFile));
//                String tenantId = tenantProperties.getProperty("name");
//
//                String driverClassName = tenantProperties.getProperty("driver-class-name");
//                String url = tenantProperties.getProperty("url");
//                String username = tenantProperties.getProperty("username");
//                String password = tenantProperties.getProperty("password");
//
//                HikariDataSource dataSource = new HikariDataSource();
//                dataSource.setDriverClassName(driverClassName);
//                dataSource.setJdbcUrl(url);
//                dataSource.setUsername(username);
//                dataSource.setPassword(password);
//
//                resolvedDataSources.put(tenantId, dataSource);
//            } catch (IOException exp) {
//                throw new RuntimeException("Problem in tenant datasource:" + exp);
//            }
//        }
//
//        AbstractRoutingDataSource dataSource = new MultitenantDataSource();
//        dataSource.setDefaultTargetDataSource(resolvedDataSources.get(defaultTenant));
//        dataSource.setTargetDataSources(resolvedDataSources);
//
//        dataSource.afterPropertiesSet();
//        return dataSource;
//    }
//}
