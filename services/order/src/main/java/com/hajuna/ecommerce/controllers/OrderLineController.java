package com.hajuna.ecommerce.controllers;

import com.hajuna.ecommerce.commons.APIResponse;
import com.hajuna.ecommerce.models.OrderLine;
import com.hajuna.ecommerce.services.interfaces.IOrderLineService;
import com.hajuna.ecommerce.utils.ResponseUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.prefix}/order-line")
@RequiredArgsConstructor
public class OrderLineController {
    private final IOrderLineService orderLineService;

    @GetMapping("/order/{orderId}")
    public ResponseEntity<APIResponse> findByOrderId(@PathVariable Long orderId) {
        return ResponseUtils.ok(orderLineService.findByOrderId(orderId));
    }
}
