package org.example.panacea;

import org.springframework.boot.SpringApplication;

public class TestPanaceaApplication {

    public static void main(String[] args) {
        SpringApplication.from(PanaceaApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
