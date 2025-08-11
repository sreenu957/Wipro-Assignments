package com.ecommerce.service;

import java.util.List;

public class OrderServiceImpl  implements OrderService{
	
	private final CartValidator cartValidator;
    private final InventoryService inventoryService;

    public OrderServiceImpl(CartValidator cartValidator, InventoryService inventoryService) {
        this.cartValidator = cartValidator;
        this.inventoryService = inventoryService;
    }

    @Override
    public String checkout(String cartId) {
        if (!cartValidator.validateCart(cartId)) {
            return "Cart is invalid";
        }

        List<String> items = inventoryService.getItemsInCart(cartId);

        for (String item : items) {
            if (!inventoryService.isAvailable(item)) {
                return "Item " + item + " is out of stock";
            }
        }

        return "Checkout successful for " + cartId;
    }
}
