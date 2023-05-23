package com.example.hackatonrowi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class HackatonrowiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HackatonrowiApplication.class, args);
	}

}
