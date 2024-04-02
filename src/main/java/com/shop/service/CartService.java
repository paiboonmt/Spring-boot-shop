package com.shop.service;

import com.shop.entity.Cart;
import com.shop.repository.CartRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepo repo;

    public void addCart(Cart cart)
    {
        repo.save(cart);
    }

    public List<Cart> carts() {
        return repo.findAll();
    }


    public void addToItemCart(Integer productId, int quantity, String product_name, double price) {
        Cart cart = new Cart();
        cart.setProduct_id(productId);
        cart.setQuantity(quantity);
        cart.setProduct_name(product_name);
        cart.setPrice(price);
        repo.save(cart);
    }
}
