package com.company.orders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@ComponentScan(basePackages = {
        "com.company.orders",   // servicios, config dentro del paquete base
        "controller"            // tu controlador está en paquete raíz 'controller'
})
@EnableJpaRepositories(basePackages = {
        "repository"            // tu OrderRepository está en paquete raíz 'repository'
})
@EntityScan(basePackages = {
        "com.company.orders.domain" // tus entidades (Order)
})
@ConfigurationPropertiesScan(basePackages = {
        "config"                // tus @ConfigurationProperties (AppProperties)
})
public class OrderManagementApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderManagementApplication.class, args);
    }
}





