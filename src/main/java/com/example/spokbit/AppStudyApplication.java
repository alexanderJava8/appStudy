package com.example.spokbit;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "apps study", version = "1.0"),
					servers = {@Server(url = "www.app.com",
							   description = "this is a app to study")})

public class AppStudyApplication {
	public static void main(String[] args) {
		SpringApplication.run(AppStudyApplication.class, args);
	}
}
