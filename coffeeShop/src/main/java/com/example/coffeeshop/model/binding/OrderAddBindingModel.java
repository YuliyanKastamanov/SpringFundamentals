package com.example.coffeeshop.model.binding;

import com.example.coffeeshop.model.entity.Category;
import com.example.coffeeshop.model.entity.CategoryNameEnum;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderAddBindingModel {

    private String name;
    private BigDecimal price;
    private LocalDateTime orderedTime;
    private CategoryNameEnum category;
    private String description;

    public OrderAddBindingModel() {
    }

    @Size(min = 3, max = 20)
    @NotNull
    public String getName() {
        return name;
    }

    public OrderAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    @Positive
    @NotNull
    public BigDecimal getPrice() {
        return price;
    }

    public OrderAddBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    public LocalDateTime getOrderedTime() {
        return orderedTime;
    }

    public OrderAddBindingModel setOrderedTime(LocalDateTime orderedTime) {
        this.orderedTime = orderedTime;
        return this;
    }

    @NotNull
    public CategoryNameEnum getCategory() {
        return category;
    }

    public OrderAddBindingModel setCategory(CategoryNameEnum category) {
        this.category = category;
        return this;
    }


    @Size(min = 5)
    public String getDescription() {
        return description;
    }

    public OrderAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }
}
