package com.codecool.shop.controller;

import com.codecool.shop.model.Product;
import com.codecool.shop.service.ProductService;
import com.codecool.shop.service.ProductStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin("localhost:3000")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/api")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @PostMapping(
            path = "/api/{productId}/image/upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public void uploadProductImage(@PathVariable("productId") int productId,
                                   @RequestParam("file")MultipartFile file) {
        productService.uploadProductImage(productId, file);
    }
}
