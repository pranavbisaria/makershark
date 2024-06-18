package com.makersharks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MakerSharksApplication {
	public static void main(String[] args) {
		SpringApplication.run(MakerSharksApplication.class, args);
	}
}
