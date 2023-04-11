package com.gof;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Projeto gerado Spring Initializr com os seguintes modulos:
 * - Spring Data JPA;
 * - Sprig Web;
 * - H2 Database;
 * - OpenFeign
 */
@EnableFeignClients
@SpringBootApplication
@EnableSwagger2
public class LabPadroesProjetoSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabPadroesProjetoSpringApplication.class, args);
	}

}
