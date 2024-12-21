package com.hajuna.ecommerce.clients;

import com.hajuna.ecommerce.dto.responses.CustomerResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(
        name = "customer-service",
        url = "${application.config.customer-url}"
)
public interface CustomerClient {

    @GetMapping("/client/{customerId}")
    Optional<CustomerResponseDTO> findCustomerById(@PathVariable("customerId") String customerId);
}
