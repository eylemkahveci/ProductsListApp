package com.project.productapp.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.productapp.entity.Product;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    //JSON datas to Java datas
    private final ObjectMapper objectMapper;

    //constructor
    public ProductService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    //list the products by getting from JSON file
    public List<Product> getAllProducts() throws IOException {
        ClassPathResource resource = new ClassPathResource("products.json");
        return objectMapper.readValue(resource.getFile(), new TypeReference<List<Product>>() {
        });
    }
}
