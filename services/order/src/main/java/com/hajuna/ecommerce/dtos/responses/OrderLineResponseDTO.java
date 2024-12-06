package com.hajuna.ecommerce.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineResponseDTO {
    Long id;
    int quantity;
}
