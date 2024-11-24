package com.project.productapp.entity;

import lombok.Data;

@Data
public class Product {
    private String name;
    private int popularityScore;
    private double weight;
    private Images images;
    private double price;

    //calculate based on the formula
    public double calculatePrice(double goldPrice) {
        double calculatedPrice=(popularityScore + 1) * weight * goldPrice;
        return calculatedPrice;
    }

    //set method
    public void setPrice(double price) {
        this.price = price;
    }

    @Data
    public static class Images {
        private String yellow;
        private String rose;
        private String white;
    }
}
