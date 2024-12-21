package com.hajuna.ecommerce.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderLineRequestDTO {
    public Long id;
    public Long orderId;
    public Long productId;
    public int quantity;
}
