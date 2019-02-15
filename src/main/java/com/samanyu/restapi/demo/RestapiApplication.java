package com.samanyu.restapi.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@EnableJpaAuditing
public class RestapiApplication {

    @RequestMapping("/")
    String home()
    {
        return "Hello World!";
    }

    public static void main(String[] args) {
        SpringApplication.run(RestapiApplication.class, args);
    }

}

