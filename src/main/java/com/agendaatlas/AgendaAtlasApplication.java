package com.agendaatlas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.agendaatlas")
public class AgendaAtlasApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgendaAtlasApplication.class, args);
	}

}
