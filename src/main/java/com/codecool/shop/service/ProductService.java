package com.codecool.shop.service;

import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class ProductService {

    private final ProductDao productDao;

    @Autowired
    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public List<Product> getProducts() {
        return productDao.getProducts();
    }

    public void uploadProductImage(int productId, MultipartFile file) {
        // 1. Check if img is not empty
        // 2. Check if file is an img
        // 3. Grab metadata from file
        // 4. Store the image in s3
        // 5. Update the database with the s3 img link
    }
}
