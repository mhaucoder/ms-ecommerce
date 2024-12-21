package com.hajuna.ecommerce.controllers;

import com.hajuna.ecommerce.utils.commons.APIResponse;
import com.hajuna.ecommerce.dto.requests.OrderRequestDTO;
import com.hajuna.ecommerce.services.interfaces.IOrderService;
import com.hajuna.ecommerce.utils.ResponseUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("${api.prefix}/orders")
public class OrderController {
    private final IOrderService orderService;

    @PostMapping
    public ResponseEntity<APIResponse> createOrder(@RequestBody @Valid OrderRequestDTO orderRequestDTO) {
        return ResponseUtils.created(orderService.createOrder(orderRequestDTO));
    }

    @GetMapping("/all")
    public ResponseEntity<APIResponse> findAll() {
        return ResponseUtils.ok(orderService.findAll());
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<APIResponse> findById(@PathVariable Long orderId) {
        return ResponseUtils.ok(orderService.findById(orderId));
    }
}
