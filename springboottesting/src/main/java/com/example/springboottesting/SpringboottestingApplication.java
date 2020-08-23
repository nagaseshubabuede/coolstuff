package com.example.springboottesting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SpringboottestingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringboottestingApplication.class, args);
	}

}
