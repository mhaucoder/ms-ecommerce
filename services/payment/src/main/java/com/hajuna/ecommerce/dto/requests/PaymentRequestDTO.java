package com.hajuna.ecommerce.dto.requests;

import com.hajuna.ecommerce.utils.enums.PaymentMethod;
import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequestDTO {
    public Long id;
    public BigDecimal amount;
    public PaymentMethod paymentMethod;
    public Long orderId;
    public String orderReference;
    public CustomerRequestDTO customer;
}
