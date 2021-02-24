package com.codecool.shop.repository;

import com.codecool.shop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Transactional
    @Modifying
    @Query("update Product p set p.imageLink = :imageLink WHERE p.id = :productId")
    void setProductImageLink(@Param("productId") Long id, @Param("imageLink") String imageLink);
}
