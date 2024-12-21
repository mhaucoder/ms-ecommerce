package com.hajuna.ecommerce.dto.requests;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hajuna.ecommerce.utils.enums.PaymentMethod;

import java.math.BigDecimal;
import java.util.List;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_EMPTY)
public class OrderRequestDTO {

    public Long id;
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
