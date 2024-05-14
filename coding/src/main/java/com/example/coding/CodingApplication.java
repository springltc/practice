package com.example.coding;

import com.example.coding.spring.CustomApplicationContextInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class CodingApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(CodingApplication.class);
        application.addInitializers(new CustomApplicationContextInitializer());
        application.run(args);
    }

}
