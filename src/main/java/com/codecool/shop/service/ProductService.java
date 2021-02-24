package com.codecool.shop.service;

import com.codecool.shop.bucket.BucketName;
import com.codecool.shop.model.Product;
import com.codecool.shop.repository.ProductRepository;
import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@Service
public class ProductService {

    private ProductRepository productRepository;
    private UserService userService;
    private FileStore fileStore;

    @Autowired
    public ProductService(ProductRepository productRepository,
                          UserService userService,
                          FileStore fileStore) {
        this.productRepository = productRepository;
        this.userService = userService;
        this.fileStore = fileStore;
    }

    public byte[] downloadProductImage(long productId) {
        Product product = productRepository.findById(productId).orElseThrow(
                () -> new IllegalStateException("Didn't find product with id: " + productId)
        );
        String path = String.format("%s/%s",
                BucketName.IMAGE.getBucketName(),
                productId);

        if (product.getImageLink() != null) {
            return fileStore.download(path, product.getImageLink());
        }

        return null;
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

        // Check if image is empty
        if (file.isEmpty()) {
            throw new IllegalStateException("Cannot upload empty file");
        }
        // If file is an image
        if (!Arrays.asList(ContentType.IMAGE_JPEG.getMimeType(), ContentType.IMAGE_PNG.getMimeType()).contains(file.getContentType())) {
            throw new IllegalStateException("File must be an image [" + file.getContentType() + "]");
        }
        // Check if the product is in the database
        Product product = productRepository.findById(productId).orElseThrow(
                () -> new IllegalStateException("Didn't find product with id: " + productId)
        );

        // Grab metadata if any
        Map<String, String> metadata = new HashMap<>();
        metadata.put("Content-Type", file.getContentType());
        metadata.put("Content-Length", String.valueOf(file.getSize()));
        // 4. Store the img
        String path = String.format("%s/%s", BucketName.IMAGE.getBucketName(), productId);
        String filename = String.format("%s-%s", file.getOriginalFilename(), productId);

        try {
            fileStore.save(path, filename, Optional.of(metadata), file.getInputStream());
            // Update db with s3 imgLink
            productRepository.setProductImageLink(productId, filename);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }


    }
}
