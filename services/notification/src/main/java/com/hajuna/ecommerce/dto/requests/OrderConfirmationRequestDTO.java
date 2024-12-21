package com.hajuna.ecommerce.dto.requests;

import com.hajuna.ecommerce.dto.responses.CustomerResponseDTO;
import com.hajuna.ecommerce.dto.responses.PurchaseProductResponseDTO;
import com.hajuna.ecommerce.utils.enums.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderConfirmationRequestDTO {
    public String orderReference;
    public BigDecimal totalAmount;
    public PaymentMethod paymentMethod;
    public CustomerResponseDTO customer;
    public List<PurchaseProductResponseDTO> products;
}
