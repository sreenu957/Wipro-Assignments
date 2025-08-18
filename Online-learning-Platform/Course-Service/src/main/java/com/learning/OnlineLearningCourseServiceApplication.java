package com.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.learning.client")
public class OnlineLearningCourseServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineLearningCourseServiceApplication.class, args);
	}

}
