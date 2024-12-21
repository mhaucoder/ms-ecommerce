package com.hajuna.ecommerce.dto.response;

import com.hajuna.ecommerce.dto.ImageDTO;
import com.hajuna.ecommerce.models.Category;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PurchaseProductResponseDTO {
    public Long productId;
    public String name;
    public String description;
    public BigDecimal price;
    public int quantity;
}
