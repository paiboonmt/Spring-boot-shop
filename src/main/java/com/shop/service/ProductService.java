package com.shop.service;

import com.shop.entity.Product;
import com.shop.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.File;
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

    public void deleteImageById(Integer id) {
        Optional<Product> optionalImage = repo.findById(id);
        if (optionalImage.isPresent()) {
            Product image = optionalImage.get();
            // Delete image file from folder
            File file = new File("src/main/resources/static/images/products/" + image.getImage());
            if (file.exists()) {
                file.delete();
            }
            // Delete from database
            repo.deleteById(id);
        } else {
            // Handle if image with given ID doesn't exist
            throw new IllegalArgumentException("Image not found with ID: " + id);
        }
    }

    // ลบสินค้า
    public void deleteById( int id){
        repo.deleteById(id);
    }
}
