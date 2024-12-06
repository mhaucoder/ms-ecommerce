package com.hajuna.ecommerce.dtos.requests;

import com.hajuna.ecommerce.dtos.responses.CustomerResponseDTO;
import com.hajuna.ecommerce.dtos.responses.PurchaseProductResponseDTO;
import com.hajuna.ecommerce.enums.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
public class OrderConfirmation {
    public String orderReference;
    public BigDecimal totalAmount;
    public PaymentMethod paymentMethod;
    public CustomerResponseDTO customer;
    public List<PurchaseProductResponseDTO> products;
}
