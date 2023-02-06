package com.credibanco.assessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("base path ")
public class BackMysqlRestNexos278Application {

	public static void main(String[] args) {
		SpringApplication.run(BackMysqlRestNexos278Application.class, args);
	}

}
