package com.ecommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.ecommerce.service.CartValidator;
import com.ecommerce.service.CartValidatorImpl;
import com.ecommerce.service.InventoryService;
import com.ecommerce.service.InventoryServiceImpl;
import com.ecommerce.service.OrderService;
import com.ecommerce.service.OrderServiceImpl;

@Configuration
@ComponentScan(basePackages="com.ecommerce")
public class AppConfig {
	
	@Bean
    public InventoryService inventoryService() {
        return new InventoryServiceImpl();
    }

    @Bean
    public CartValidator cartValidator() {
        return new CartValidatorImpl();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(cartValidator(), inventoryService());
    }
  
}
