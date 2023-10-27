package com.baris.quizApplication;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class QuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizApplication.class, args);
	}
	@Bean
	public OpenAPI openAPI(@Value("Quiz Application") String description,
						   @Value("1.0") String version){
		return new OpenAPI()
				.info(new Info()
						.title("Quiz Application API")
						.version(version)
						.description(description)
						.license(new License().name("Quiz Application License")));
	}

}
