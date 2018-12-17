package com.ustc.reed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Sb01Application {

	public static void main(String[] args) {

		SpringApplication.run(Sb01Application.class, args);
	}
}
