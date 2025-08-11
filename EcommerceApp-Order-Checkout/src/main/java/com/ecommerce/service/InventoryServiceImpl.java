package com.ecommerce.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl  implements InventoryService{
	

	private static final Map<String, List<String>> cartItems = Map.of(
	        "CART001", Arrays.asList("ITEM001", "ITEM002"),
	        "CART002", Arrays.asList("ITEM003")
	    );

	    private static final List<String> availableItems =
	        Arrays.asList("ITEM001", "ITEM002", "ITEM003");

	    @Override
	    public boolean isAvailable(String itemId) {
	        return availableItems.contains(itemId);
	    }

	    @Override
	    public List<String> getItemsInCart(String cartId) {
	        return cartItems.getOrDefault(cartId, List.of());
	    }

}
