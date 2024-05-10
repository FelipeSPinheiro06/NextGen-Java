package com.fiap.nextgen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableCaching
@OpenAPIDefinition(
	info = @Info(
		title = "NextGen",
		summary = "API do App NextGen",
		description = "Sistema de Gestão de Experiência do Cliente",
		version = "1.0.0",
		contact = @Contact(
			name = "Felipe Pinheiro",
			email = "fsp12371@gmail.com"
		)
	) 
)
public class NextgenApplication {

	public static void main(String[] args) {
		SpringApplication.run(NextgenApplication.class, args);
	}

}
