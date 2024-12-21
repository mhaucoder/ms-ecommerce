package com.hajuna.ecommerce.dto.requests;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseProductRequestDTO {

    @NotNull(message = "Product ID cannot be null")
    @Positive(message = "Product ID must be a positive value")
    public Long productId;

    @Min(value = 1, message = "Quantity must be at least 1")
    public int quantity;

}
