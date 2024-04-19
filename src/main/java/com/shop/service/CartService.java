package com.shop.service;

import com.shop.entity.Cart;
import com.shop.repository.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepo repo;

    public List<Cart> findAll() {
        return repo.findAll();
    }

    public Cart findById(int id) {
        Optional<Cart> cart = repo.findById(id);
        return cart.orElse(null);
    }

    public Cart save(Cart cart) {
        return repo.save(cart);
    }

    public void delete(int id) {
        repo.deleteById(id);
    }


    public void deleteByUserrole(int id) {
        repo.deleteByUserrole(id);
    }

}
