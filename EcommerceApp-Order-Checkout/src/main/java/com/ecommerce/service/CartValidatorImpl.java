package com.ecommerce.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CartValidatorImpl  implements CartValidator{

	 private static final List<String> validCarts = Arrays.asList("CART001", "CART002");
	 
	@Override
	public boolean validateCart(String cartId) {
		
		return validCarts.contains(cartId);
	}

}
