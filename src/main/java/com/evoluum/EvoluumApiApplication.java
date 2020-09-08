package com.evoluum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class EvoluumApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EvoluumApiApplication.class, args);
	}

}
