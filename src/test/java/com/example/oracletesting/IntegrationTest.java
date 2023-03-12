package com.example.oracletesting;

import org.springframework.boot.test.context.SpringBootTest;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@SpringBootTest(
        classes = {IntegrationTestConfig.class},
        properties= {
                "spring.datasource.username=app",
                "spring.datasource.password=app_pass"
        }
)
public @interface IntegrationTest {
}
