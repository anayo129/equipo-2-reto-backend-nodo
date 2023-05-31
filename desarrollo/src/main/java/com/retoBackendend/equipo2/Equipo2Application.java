package com.retoBackendend.equipo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.retoBackendend.equipo2.repositories")
public class Equipo2Application {

	public static void main(String[] args) {
		SpringApplication.run(Equipo2Application.class, args);
	}

}
