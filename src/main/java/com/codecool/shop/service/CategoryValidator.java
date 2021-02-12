package com.codecool.shop.service;

import com.codecool.shop.model.ProductCategory;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class CategoryValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return ProductCategory.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        ProductCategory category = (ProductCategory) o;

        if (category != ProductCategory.ELECTRONICS && category != ProductCategory.ESTATE &&
        category != ProductCategory.HOUSEHOLD && category != ProductCategory.SPORTS) {
            errors.rejectValue("category", "unavailable category");
        }
    }
}
