package com.spirngboot.annotation.in;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringAnnotationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAnnotationApplication.class, args);
	}
	
	@Bean
    public CommandLineRunner run(MyService myService) {
        return args -> {
            myService.serve(); // Call the method with @LogExecutionTime
        };
    }

}
