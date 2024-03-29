package com.ustc.reed;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableCaching
@EnableSwagger2
@MapperScan("com.ustc.reed.mapper")
public class Sb01Application {

	public static void main(String[] args) {

		SpringApplication.run(Sb01Application.class, args);
	}
}
