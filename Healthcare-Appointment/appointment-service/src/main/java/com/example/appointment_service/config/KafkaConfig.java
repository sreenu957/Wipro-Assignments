package com.example.appointment_service.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {
	private static final String TOPIC = "appointment-confirmed";
	
	@Bean
	public NewTopic appointmentConfirmedTopic() {
		return TopicBuilder.name("appointment-confirmed")
							.build();
	}
	
	}