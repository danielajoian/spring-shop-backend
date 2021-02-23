package com.codecool.shop.service;

import com.codecool.shop.model.Product;
import com.codecool.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
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
        return productRepository.save(productToAdd);
    }

    public Product updateProduct(Product product, long id) {
        Product elemToUpdate = productRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("No product found with id: " + id)
        );

        elemToUpdate.setTitle(product.getTitle());
        elemToUpdate.setDescription(product.getDescription());
        elemToUpdate.setCategory(product.getCategory());
        elemToUpdate.setPrice(product.getPrice());
        elemToUpdate.setImageLink(product.getImageLink());
        elemToUpdate.setUser(product.getUser());

        return productRepository.save(elemToUpdate);
    }
}
