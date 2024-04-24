package com.shop.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.shop.entity.Product;
import com.shop.service.ProductService;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public String product( Model model){
        List<Product> products = service.allProduct();
        model.addAttribute("product" , products);
        model.addAttribute("currentUrl", "/product");
        return "product";
    }

    @GetMapping("/deleteproduct/{id}")
    public String deleteProduct(@PathVariable Integer id  ){

        service.deleteImageById(id);
        service.deleteById(id);

        return "redirect:/product";
    }

    @PostMapping("/updateproduct")
    public String updateProduct(@RequestParam int id,
                                @RequestParam("newImage") MultipartFile file,
                                @RequestParam("image") String image,
                                @RequestParam("name") String name ,
                                @RequestParam("price") Double price ,
                                @RequestParam("detail") String detail ,
                                @RequestParam("quantity") int quantity
    ) throws IOException {
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setPrice(price);
        product.setDetail(detail);
        product.setQuantity(quantity);

        if ( file !=null && !file.isEmpty()) {
//            System.out.println("200");
//            System.out.println(id);

            service.deleteImageById(id);

            long micrometer = java.time.Instant.now().toEpochMilli();
            String folder = "src/main/resources/static/images/products/";
            byte[] bytes = file.getBytes();
            String fileName = micrometer  + "_" + ".jpg";
            Path path = Paths.get(folder + fileName);
            Files.write(path, bytes);
            product.setImage(fileName);
        } else {
//            System.out.println(id);
//            System.out.println(image);
            product.setImage(image);
        }

        service.updateProduct(product);



        return "redirect:/product";
    }

    @GetMapping("/editproduct/{id}")
    public String editProduct(@PathVariable int id , Model model){
        Product product = (Product) service.getProductById(id);
        model.addAttribute("currentUrl", "/product");
        model.addAttribute("products", product);
        return "editproduct";
    }

    @GetMapping("/addproduct")
    public String addProduct(Model model){
        model.addAttribute("currentUrl", "/product");
        return "addproduct";
    }

    @SuppressWarnings("unused")
    @PostMapping("/addProduct")
    public String insertProduct( @RequestParam("image") MultipartFile file,
                                 @RequestParam("name") String name ,
                                 @RequestParam("price") Double price ,
                                 @RequestParam("detail") String detail ,
                                 @RequestParam("quantity") int quantity ) throws IOException {

        Product product =  new Product();
        product.setName(name);
        product.setPrice(price);
        product.setDetail(detail);
        product.setQuantity(quantity);

        Instant Instant = null;
        long micrometer = java.time.Instant.now().toEpochMilli();
        
        String folder = "src/main/resources/static/images/products/";
        byte[] bytes = file.getBytes();

        String fileName = micrometer  + "_" + ".jpg";
        Path path = Paths.get(folder + fileName);

        Files.write(path, bytes);

        product.setImage(fileName);
        service.addProduct(product);
        return "redirect:/product";
    }
}
