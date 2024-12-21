package com.hajuna.ecommerce.services.interfaces;

import com.hajuna.ecommerce.dto.responses.PurchaseProductResponseDTO;
import jakarta.mail.MessagingException;

import java.math.BigDecimal;
import java.util.List;

public interface IEmailService {
    void sendPaymentConfirmationEmail( String destinationEmail, String customerName, BigDecimal amount, String orderReference) throws MessagingException;
    void sendOrderConfirmationEmail( String destinationEmail, String customerName, BigDecimal amount, String orderReference, List<PurchaseProductResponseDTO> products) throws MessagingException;
}
