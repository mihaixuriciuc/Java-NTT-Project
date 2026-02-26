package com.example.manual;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 1. The Magic Tag
@SpringBootApplication
public class Application {

    // 2. The standard Java starting point
    public static void main(String[] args) {

        // 3. The Ignition Switch
        SpringApplication.run(Application.class, args);
    }
}