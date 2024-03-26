package com.shop.service;

import com.shop.entity.Product;
import com.shop.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;

    @SuppressWarnings("null")
    public void addProduct(Product product) {

        repo.save(product);
    }

    public List<Product> allProduct() {
        return repo.findAll();
    }

    public Product getProductById( int id){
        Optional<Product> product = repo.findById(id);
        if ( product.isPresent()) {
            return product.get();
        }
        return null;
    }

    public void deleteById( int id){
        repo.deleteById(id);
    }
}
