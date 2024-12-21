package com.hajuna.ecommerce.controllers;

import com.hajuna.ecommerce.utils.commons.APIResponse;
import com.hajuna.ecommerce.dto.requests.PaymentRequestDTO;
import com.hajuna.ecommerce.services.interfaces.IPaymentService;
import com.hajuna.ecommerce.utils.ResponseUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api.prefix}/payments")
@RequiredArgsConstructor
public class PaymentController {
    private final IPaymentService paymentService;

    @PostMapping()
    public ResponseEntity<APIResponse> createPayment(@RequestBody PaymentRequestDTO payment) {
        return ResponseUtils.created(paymentService.createPayment(payment));
    }

    @PostMapping("/client")
    public ResponseEntity<Long> createPaymentForClient(@RequestBody PaymentRequestDTO payment) {
        return ResponseEntity.ok(paymentService.createPayment(payment));
    }
}
