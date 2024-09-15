package com.example.construction_project.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
class ApplicationYamlTest {

    @Autowired
    private Environment env;

    @Test
    void testServerPort() {
        String port = env.getProperty("server.port");
        assertEquals("8080", port, "Server port should be 8080");
    }

    @Test
    void testDatasourceConfiguration() {
        String url = env.getProperty("spring.datasource.url");
        String username = env.getProperty("spring.datasource.username");
        String password = env.getProperty("spring.datasource.password");
        String driver = env.getProperty("spring.datasource.driver-class-name");

        assertEquals("jdbc:mysql://localhost:3306/clinic_service", url, "Datasource URL should be correct");
        assertEquals("root", username, "Datasource username should be 'root'");
        assertEquals("a2009300babych", password, "Datasource password should be 'a2009300babych'");
        assertEquals("com.mysql.cj.jdbc.Driver", driver, "Datasource driver should be MySQL");
    }

    @Test
    void testJpaConfiguration() {
        String showSql = env.getProperty("spring.jpa.show-sql");
        String ddlAuto = env.getProperty("spring.jpa.hibernate.ddl-auto");
        String dialect = env.getProperty("spring.jpa.properties.hibernate.dialect");

        assertEquals("true", showSql, "JPA show-sql should be enabled");
        assertEquals("update", ddlAuto, "DDL auto should be 'update'");
        assertEquals("org.hibernate.dialect.MySQL8Dialect", dialect, "Hibernate dialect should be MySQL8");
    }

    @Test
    void testLiquibaseConfiguration() {
        String changeLog = env.getProperty("spring.liquibase.change-log");
        assertEquals("classpath:db/changelog/changelog-master.xml", changeLog, "Liquibase changelog path should be correct");
    }

    @Test
    void testJWTConfiguration() {
        String secret = env.getProperty("jwt.secret");
        String expiration = env.getProperty("jwt.expiration");

        assertEquals("Zmphc2tmYXNmbEtGS3NhamZramFzO2xtZmRjc2Fjamthc2MsO2xtbHNha2pkZnNhMjM0NTYgYXNmYXM=", secret, "JWT secret should match the configuration");
        assertEquals("86400000", expiration, "JWT expiration should be 86400000");
    }
}
