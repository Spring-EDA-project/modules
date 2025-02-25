package com.eda.internal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.eda.common", "com.eda.domain", "com.eda.rdbms", "com.eda.internal"})
public class ModuleInternalApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModuleInternalApiApplication.class, args);
    }

}
