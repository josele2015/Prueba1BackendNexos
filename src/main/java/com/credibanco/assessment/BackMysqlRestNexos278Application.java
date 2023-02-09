package com.credibanco.assessment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//import com.credibanco.assessment.card.controller.ControllerTarjeta;

//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
//@EnableTransactionManagement
//@EnableJpaRepositories(basePackages = "com.calendar.repository")
@SpringBootApplication
public class BackMysqlRestNexos278Application {

	public static void main(String[] args) {
		SpringApplication.run(BackMysqlRestNexos278Application.class, args);
	}

}
