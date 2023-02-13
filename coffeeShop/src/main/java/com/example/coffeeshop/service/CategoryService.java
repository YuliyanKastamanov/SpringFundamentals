package com.example.coffeeshop.service;

import com.example.coffeeshop.model.entity.Category;
import com.example.coffeeshop.model.entity.CategoryNameEnum;

public interface CategoryService {
    void initCategories();

    Category findByCategoryNameEnum(CategoryNameEnum categoryNameEnum);
}
