package com.project.productapp.controllers;

import com.project.productapp.entity.Product;
import com.project.productapp.services.GoldPriceService;
import com.project.productapp.services.ProductService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;


import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")

public class ProductController {

    private final ProductService productService;
    private final GoldPriceService goldPriceService;

    public ProductController(ProductService productService, GoldPriceService goldPriceService) {
        this.productService = productService;
        this.goldPriceService = goldPriceService;
    }

    //to get the products from API
    @GetMapping("/api/products")
    public List<Product> getProducts(@RequestParam(value = "goldPrice", defaultValue = "1000.0") double goldPrice) {
        try {
            List<Product> products = productService.getAllProducts();

            for (Product product : products) {
                product.setPrice(product.calculatePrice(goldPrice));
            }

            return products;
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error reading products from file", e);
        }
    }
}
