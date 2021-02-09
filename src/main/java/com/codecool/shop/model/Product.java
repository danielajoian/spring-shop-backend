package com.codecool.shop.model;

public class Product {

    private int id;
    private String title;
    private String description;
    private ProductCategory category;
    private double price;
    private String imageLink;
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
//        this.sellerInfo = sellerInfo;
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

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    //    public SellerInfo getSellerInfo() {
//        return sellerInfo;
//    }
//
//    public void setSellerInfo(SellerInfo sellerInfo) {
//        this.sellerInfo = sellerInfo;
//    }
}
