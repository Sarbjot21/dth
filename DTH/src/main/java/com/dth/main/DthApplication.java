package com.dth.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@EnableAutoConfiguration()
public class DthApplication {

	public static void main(String[] args) {
		SpringApplication.run(DthApplication.class, args);
	}
}
