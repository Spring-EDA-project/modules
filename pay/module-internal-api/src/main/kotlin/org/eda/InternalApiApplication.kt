package org.eda

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class InternalApiApplication

fun main(args: Array<String>) {
    runApplication<InternalApiApplication>(*args);
}