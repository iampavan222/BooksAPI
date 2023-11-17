package com.amazon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "com.amazon")
public class SpringBootMvcRestApi05CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMvcRestApi05CrudApplication.class, args);
	}

}
