package com.codecool.shop.model;

import java.util.Objects;
import java.util.Optional;

public class Product {

    private int id;
    private String title;
    private String description;
    private ProductCategory category;
    private double price;
    private String imageLink; // S3 key
//    private SellerInfo sellerInfo;

    public Product() {

    }

    public Product(int id, String title, String description, ProductCategory category, double price, String imageLink) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.price = price;
        this.imageLink = imageLink;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Optional<String> getImageLink() {
        return Optional.ofNullable(imageLink);
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    //    public SellerInfo getSellerInfo() {
//        return sellerInfo;
//    }
//
//    public void setSellerInfo(SellerInfo sellerInfo) {
//        this.sellerInfo = sellerInfo;
//    }
}
