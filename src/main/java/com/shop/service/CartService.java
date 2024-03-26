package com.shop.service;

import com.shop.entity.Cart;
import com.shop.entity.Product;
import com.shop.repository.CartRepo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private CartRepo repo;


    @SuppressWarnings("null")
    public void addCart(Cart cart )
    {
        repo.save(cart);
    }

    
}
