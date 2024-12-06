package com.hajuna.ecommerce.dtos.responses;

import com.hajuna.ecommerce.dtos.requests.PurchaseProductRequestDTO;
import com.hajuna.ecommerce.enums.PaymentMethod;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

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
