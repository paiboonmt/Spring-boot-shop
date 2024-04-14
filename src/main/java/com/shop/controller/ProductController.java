package com.shop.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.shop.entity.Product;
import com.shop.service.ProductService;
import org.springframework.web.multipart.MultipartFile;

import static java.lang.Math.random;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

//    http://localhost:1010/product
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

    @PostMapping("/updateProduct")
    public String updateProduct(@RequestParam int id,
                                @ModelAttribute Product product ,
                                Model model ,
                                BindingResult result)  {

        try {
            Product p = service.getProductById(id);
            model.addAttribute("p" , p);

            if ( result.hasErrors()){
                return "product";
            }

            if( ! p.getImage().isEmpty() ){
                String folder = "src/main/resources/static/images/products/";
                Path oldImage = Paths.get(folder + p.getImage());
                try {
                    Files.delete(oldImage);
                }catch (Exception exception){
                    System.out.println("Exception :" + exception.getMessage());
                }

                String micrometer = null;
                String fileName = micrometer  + "_" + ".jpg";
                Path path = Paths.get(folder + fileName);

            }
        }
        catch (Exception exception){
            System.out.println("Exception :" + exception.getMessage());
        }



//        long micrometer = java.time.Instant.now().toEpochMilli();
//        String folder = "src/main/resources/static/images/products/";
//        byte[] bytes = file.getBytes();
//        String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
//        String fileName = micrometer  + "_" + ".jpg";
//        Path path = Paths.get(folder + fileName);
//        Files.write(path, bytes);
//
//        Product product =  new Product();
//        product.setName(name);
//        product.setPrice(price);
//        product.setDetail(detail);
//        product.setQuantity(quantity);
//
//        product.setImage(fileName);
//        service.addProduct(product);
        return "redirect:/product";
    }

    @GetMapping("/editproduct/{id}")
    public String editProduct(@PathVariable int id , Model model){
        Product product = service.getProductById(id);
        model.addAttribute("currentUrl", "/product");
        model.addAttribute("products", product);
        return "editproduct";
    }


//    @PostMapping("/setEditProduct/{id}")
//    public String setEditProduct(@PathVariable int id ,@RequestBody Product product, Model model){
//        Product product = service.getProductById(id);
//        model.addAttribute("product" , product);
//        System.out.println(product);
//        return "editproduct";
//    }

    @GetMapping("/addproduct")
    public String addProduct(Model model){
        model.addAttribute("currentUrl", "/product");
        return "addproduct";
    }


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
        long microtime = java.time.Instant.now().toEpochMilli();
        
        String folder = "src/main/resources/static/images/products/";
        byte[] bytes = file.getBytes();
//        String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
        String fileName = microtime  + "_" + ".jpg";
        Path path = Paths.get(folder + fileName);
        Files.write(path, bytes);

        product.setImage(fileName);
        service.addProduct(product);
        return "redirect:/product";
    }
}
