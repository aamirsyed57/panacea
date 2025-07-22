package org.example.panacea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@EnableRedisRepositories
@SpringBootApplication
public class PanaceaApplication {

    public static void main(String[] args) {
        SpringApplication.run(PanaceaApplication.class, args);
    }

}
