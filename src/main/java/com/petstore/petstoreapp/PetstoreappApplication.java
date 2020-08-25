package com.petstore.petstoreapp;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableEncryptableProperties
@SpringBootApplication
public class PetstoreappApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetstoreappApplication.class, args);
    }

}
