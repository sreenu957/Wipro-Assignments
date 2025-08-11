package com.ecommerce.service;

import java.util.List;

public interface InventoryService {
	
	boolean isAvailable(String itemId);
	List<String> getItemsInCart(String cartId);

}
