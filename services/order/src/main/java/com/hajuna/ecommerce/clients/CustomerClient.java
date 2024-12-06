package com.hajuna.ecommerce.clients;

import com.hajuna.ecommerce.dtos.responses.CustomerResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(
        name = "customer_service",
        url = "${application.config.customer-url}"
)
public interface CustomerClient {

    @GetMapping("/{customerId}")
    Optional<CustomerResponseDTO> findCustomerById(@PathVariable("customerId") String customerId);
}
