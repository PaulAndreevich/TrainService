package com.example.trains;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({ "com.example.data","com.example.controller","com.example.exceptions","com.example.response", "com.example.blocks"} )
@EntityScan({"com.example.blocks","com.example.exceptions","com.example.counter"})
@EnableJpaRepositories("com.example.data")
public class TrainServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(TrainServiceApplication.class,args);
    }
}
