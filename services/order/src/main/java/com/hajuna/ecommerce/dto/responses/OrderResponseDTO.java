package com.hajuna.ecommerce.dto.responses;

import com.hajuna.ecommerce.utils.enums.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDTO {
    public Long id;
    public String reference;
    public BigDecimal amount;
    public PaymentMethod paymentMethod;
    public String customerId;
}
