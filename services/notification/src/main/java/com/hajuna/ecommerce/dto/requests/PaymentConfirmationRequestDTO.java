package com.hajuna.ecommerce.dto.requests;

import com.hajuna.ecommerce.utils.enums.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentConfirmationRequestDTO {
    public String orderReference;
    public BigDecimal amount;
    public PaymentMethod paymentMethod;
    public String customerFirstName;
    public String customerLastName;
    public String customerEmail;
    public String customerPhone;
}
