package com.company.orders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "domain")
@EnableJpaRepositories(basePackages = "repository")
@ComponentScan(basePackages = {
        "com.company.orders", // app
        "domain",             // entidades
        "repository",         // repos
        "service",            // interfaz
        "serviceImpl",        // tu implementación (tal como la creaste)
        "controller"          // (cuando lo agregues)
})
public class OrderManagementApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderManagementApplication.class, args);
    }
}



