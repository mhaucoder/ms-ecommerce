package com.hajuna.ecommerce.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseProductResponseDTO {
    public Long productId;
    public String name;
    public String description;
    public BigDecimal price;
    public int quantity;
}
