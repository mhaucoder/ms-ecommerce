package com.hajuna.ecommerce.dtos.requests;

import jakarta.validation.constraints.*;

public class PurchaseProductRequestDTO {

    @NotNull(message = "Product ID cannot be null")
    @Positive(message = "Product ID must be a positive value")
    public Long productId;

    @Min(value = 1, message = "Quantity must be at least 1")
    public int quantity;

}
