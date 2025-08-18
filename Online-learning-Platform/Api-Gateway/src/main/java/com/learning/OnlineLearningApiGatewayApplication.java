package com.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OnlineLearningApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineLearningApiGatewayApplication.class, args);
	}

	@Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("Online-Learning-User-Service", r -> r.path("/api/users/**")
                        .uri("http://localhost:8081"))
                .route("Online-Learning-Course-Service", r -> r.path("/api/courses/**")
                        .uri("http://localhost:8082"))
                .route("Online-Learning-Classroom-Service", r -> r.path("/api/classrooms/**")
                		.uri("http://localhost:8083"))
                .route("Online-Learning-Assessment-Service", r -> r.path("/api/assessments/**")
                		.uri("http://localhost:8084"))
                .route("Online-Learning-Notification-Service", r -> r.path("/api/notifications/**")
                		.uri("http://localhost:8085"))
                .build();
    }
}
