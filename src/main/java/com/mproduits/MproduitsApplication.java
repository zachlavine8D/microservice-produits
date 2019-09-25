package com.mproduits;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MproduitsApplication {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(MproduitsApplication.class);
        try {
            SpringApplication.run(MproduitsApplication.class, args);
        } catch (Exception e) {
            logger.info("**********************" + e.getCause() + "**********************");
        }
    }
}
