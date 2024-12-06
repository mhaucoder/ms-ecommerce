package com.hajuna.ecommerce.dto.request;

import com.hajuna.ecommerce.models.Category;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateProductRequestDTO {
    public Long id;
    public String name;
    public String brand;
    public BigDecimal price;
    public int inventory;
    public String description;
    public Category category;
}
