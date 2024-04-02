package io.chagchagchag.example.r2dbc_example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@EnableR2dbcRepositories(
		basePackages = {"io.chagchagchag.example.r2dbc_example"}
)
@SpringBootApplication
public class R2dbcExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(R2dbcExampleApplication.class, args);
	}

}
