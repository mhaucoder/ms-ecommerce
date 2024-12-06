package com.hajuna.ecommerce.dtos.requests;

import com.hajuna.ecommerce.enums.PaymentMethod;

import java.math.BigDecimal;
import java.util.List;

import jakarta.validation.constraints.*;

public class OrderRequestDTO {

    @NotNull(message = "ID cannot be null")
    @Positive(message = "ID must be a positive value")
    public Long id;

    @NotNull(message = "Reference cannot be null")
    @NotEmpty(message = "Reference cannot be empty")
    @Size(min = 3, max = 100, message = "Reference must be between 3 and 100 characters")
    public String reference;

    @NotNull(message = "Amount cannot be null")
    @DecimalMin(value = "0.01", message = "Amount must be greater than 0")
    public BigDecimal amount;

    @NotNull(message = "Payment method cannot be null")
    public PaymentMethod paymentMethod;

    @NotNull(message = "Customer ID cannot be null")
    @NotEmpty(message = "Customer ID cannot be empty")
    public String customerId;

    @NotEmpty(message = "Products cannot be empty")
    public List<PurchaseProductRequestDTO> products;
}
