package com.codecool.shop.service;

import com.codecool.shop.model.Product;
import com.codecool.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;
    private UserService userService;

    @Autowired
    public ProductService(ProductRepository productRepository,
                          UserService userService) {
        this.productRepository = productRepository;
        this.userService = userService;
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product getProductById(long productId) {
        return productRepository.findById(productId).orElseThrow(
            () -> new IllegalArgumentException("No product found with id: " + productId)
        );
    }

    public Product addProduct(Product productToAdd) {
        productToAdd.setUser(userService.findById(1));
        return productRepository.save(productToAdd);
    }

    public void uploadProductImage(long productId, MultipartFile file) {

        // 1. Check if image is empty
        // 2. If file is an image
        // 3. Grab metadata if any
        // 4. Store the img
        // 5. Update db with s3 imgLink
    }
}
