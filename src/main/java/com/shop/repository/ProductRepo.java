package com.shop.repository;

import com.shop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.*;

@Repository
public interface ProductRepo extends JpaRepository<Product , Integer> {

    void deleteByName(String name);
}
