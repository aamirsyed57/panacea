package org.example.panacea;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.GenericContainer;

@TestConfiguration(proxyBeanMethods = false)
class TestcontainersConfiguration {

    @Bean
    @ConditionalOnMissingBean(name = "redis")
    GenericContainer<?> redisContainer() {
        return new GenericContainer<>("redis:latest").withExposedPorts(6378);
    }


    @Bean
    @ConditionalOnMissingBean(name = "rdbms")
    public GenericContainer<?> postgresContainer() {
        return new GenericContainer<>("postgres:17")
                .withEnv("POSTGRES_PASSWORD", "password")
                .withEnv("POSTGRES_USER", "user")
                .withEnv("POSTGRES_DB", "panacea")
                .withExposedPorts(5433);
    }
}
