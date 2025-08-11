package com.ecommerce.main;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecommerce.config.AppConfig;
import com.ecommerce.service.OrderService;

public class AppMain {
	
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        OrderService orderService = context.getBean(OrderService.class);

        System.out.println(orderService.checkout("CART001"));
        System.out.println(orderService.checkout("INVALID_CART"));

	}
}
