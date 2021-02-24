package com.codecool.shop.controller;

import com.codecool.shop.model.Product;
import com.codecool.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts() {
        return productService.getAll();
    }

    @GetMapping("/{productId}")
    public Product getSingleProduct(@PathVariable("productId") long productId) {
        return productService.getProductById(productId);
    }

    @PostMapping
    public Product addProduct(@RequestBody @Valid Product product) {
        return productService.addProduct(product);
    }

    @PostMapping(
            path = "/{productId}/image/upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public void uploadProductImage(@PathVariable("productId") long productId,
                                   @RequestParam("file") MultipartFile file) {
        productService.uploadProductImage(productId, file);
    }

    @GetMapping("/{productId}/image/download")
    public byte[] downloadProductImage(@PathVariable("productId") long productId) {
        return productService.downloadProductImage(productId);
    }
}
