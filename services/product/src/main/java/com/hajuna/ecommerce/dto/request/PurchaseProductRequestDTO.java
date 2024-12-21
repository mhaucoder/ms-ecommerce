package com.hajuna.ecommerce.dto.request;

import lombok.Data;

@Data
public class PurchaseProductRequestDTO {
    public Long productId;
    public int quantity;
}
