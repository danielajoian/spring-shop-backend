package com.codecool.shop.service;

import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ProductValidator implements Validator {

    private final Validator categoryValidator;

    public ProductValidator(Validator categoryValidator) {
        if (categoryValidator == null) {
            throw new IllegalArgumentException("category validator can t be null");
        }
        if (!categoryValidator.supports(ProductCategory.class)) {
            throw new IllegalArgumentException("validator must support ProductCategory class");
        }
        this.categoryValidator = categoryValidator;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Product.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "title", "title.empty");
        ValidationUtils.rejectIfEmpty(errors, "description", "description.empty");

        Product product = (Product) o;

        if (product.getPrice() < 1) {
            errors.rejectValue("price", "price.too.low");
        } else if (product.getPrice() > 10000000) {
            errors.rejectValue("price", "price.too.big");
        }

        try {
            errors.pushNestedPath("category");
            ValidationUtils.invokeValidator(this.categoryValidator, product.getCategory(), errors);
        } finally {
            errors.popNestedPath();
        }
    }
}
