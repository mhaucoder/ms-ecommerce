package com.hajuna.ecommerce.clients;

import com.hajuna.ecommerce.dto.requests.PaymentRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(
        name = "payment-service",
        url = "${application.config.payment-url}"
)
public interface PaymentClient {
    @PostMapping("/client")
    Long requestOrderPayment(PaymentRequestDTO paymentRequestDTO);
}
