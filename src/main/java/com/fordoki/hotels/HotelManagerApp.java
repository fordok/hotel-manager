package com.fordoki.hotels;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * @author rustam
 */
@SpringBootApplication
@EnableJpaAuditing
public class HotelManagerApp {

    public static void main(String[] args) {
        SpringApplication.run(HotelManagerApp.class, args);
    }

}