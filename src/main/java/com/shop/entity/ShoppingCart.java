package com.shop.entity;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Cart> cartItem;

    public ShoppingCart() {
        this.cartItem = new ArrayList<>();
    }

    public void addCartItem(Cart cart) {
        cartItem.add(cart);
    }
}
