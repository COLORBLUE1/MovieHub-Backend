package com.error404squad.MOVIEHUB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@PropertySource("classpath:db/application.properties")
public class MoviehubApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviehubApplication.class, args);
	}

}
