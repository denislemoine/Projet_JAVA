package com.dreamteam.avengor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

@SpringBootApplication(exclude = ErrorMvcAutoConfiguration.class)
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
public class AvengorApplication {

	public static void main(String[] args) {

		SpringApplication.run(AvengorApplication.class, args);

	}

}
