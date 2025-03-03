package com.eda.external;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.eda.common", "com.eda.domain", "com.eda.rdbms", "com.eda.external"})
public class ModuleExternalApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModuleExternalApiApplication.class, args);
    }

}
