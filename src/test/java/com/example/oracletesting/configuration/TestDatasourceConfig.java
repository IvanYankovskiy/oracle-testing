package com.example.oracletesting.configuration;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.testcontainers.containers.OracleContainer;

import javax.sql.DataSource;

@Configuration
public class TestDatasourceConfig {
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;

    @Bean
    public OracleContainer oracleContainer() {
        printEnvVar("TESTCONTAINERS_HOST_OVERRIDE");
        printEnvVar("TESTCONTAINERS_DOCKER_SOCKET_OVERRIDE");
        printEnvVar("DOCKER_HOST");
        OracleContainer oracleContainer = new OracleContainer("gvenzl/oracle-xe:21.3.0-slim-faststart");
        oracleContainer.withUsername(username);
        oracleContainer.withPassword(password);
        oracleContainer.withDatabaseName("OAST");
        oracleContainer.start();
        return oracleContainer;
    }

    private void printEnvVar(String env) {
        System.out.println(env + ":" + System.getenv(env));
    }

    @Primary
    @Bean
    public DataSource dataSource(OracleContainer oracleContainer) {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl(oracleContainer.getJdbcUrl());
        hikariDataSource.setUsername(username);
        hikariDataSource.setPassword(password);
        hikariDataSource.setSchema(username);
        return hikariDataSource;
    }

}
