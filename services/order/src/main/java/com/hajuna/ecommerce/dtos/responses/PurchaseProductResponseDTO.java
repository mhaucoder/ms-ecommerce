package com.hajuna.ecommerce.dtos.responses;

import java.math.BigDecimal;

public class PurchaseProductResponseDTO {
    public Long productId;
    public String name;
    public String description;
    public BigDecimal price;
    public int quantity;
}
