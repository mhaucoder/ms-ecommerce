package com.hajuna.ecommerce.dto.requests;

import com.hajuna.ecommerce.dto.responses.CustomerResponseDTO;
import com.hajuna.ecommerce.utils.enums.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequestDTO {
    public BigDecimal amount;
    public PaymentMethod paymentMethod;
    public Long orderId;
    public String orderReference;
    public CustomerResponseDTO customer;
}
