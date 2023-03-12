package com.example.oracletesting;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;


@Configuration
@EnableAutoConfiguration
@EnableConfigurationProperties
@ComponentScan(
        basePackageClasses = {OracleTestingApplication.class},
        excludeFilters = {@ComponentScan.Filter(
                type = FilterType.ASSIGNABLE_TYPE,
                value = {OracleTestingApplication.class})
        }
)
public class IntegrationTestConfig {
}
