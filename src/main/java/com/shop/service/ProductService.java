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

    // บันทึกสินค้า
    public void addProduct(Product product) {
        repo.save(product);
    }

    // แสดงสินค้าทั้งหมด
    public List<Product> allProduct() {
        return repo.findAll();
    }

    // ค้นหาสินค้าด้วย ไอดี
    public Product getProductById( int id){
        Optional<Product> product = repo.findById(id);
        return product.orElse(null);
    }

    // ลบสินค้า
    public void deleteById( int id){
        repo.deleteById(id);
    }
}
