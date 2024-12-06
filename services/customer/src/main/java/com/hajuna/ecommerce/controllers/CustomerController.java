package com.hajuna.ecommerce.controllers;

import com.hajuna.ecommerce.commons.APIResponse;
import com.hajuna.ecommerce.dto.CustomerDTO;
import com.hajuna.ecommerce.dto.request.CreateCustomerDTO;
import com.hajuna.ecommerce.dto.request.UpdateCustomerDTO;
import com.hajuna.ecommerce.models.Customer;
import com.hajuna.ecommerce.services.interfaces.ICustomerService;
import com.hajuna.ecommerce.utils.ResponseUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final ICustomerService customerService;

    @GetMapping("/getAll")
    public ResponseEntity<APIResponse> getAllCustomers() {
        List<Customer> customer = customerService.getAllCustomers();
        List<CustomerDTO> customerDTO = customerService.convertDTOList(customer);
        return ResponseUtils.ok(customerDTO);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<APIResponse> getCustomerById(@PathVariable String customerId) {
        Customer customer = customerService.getCustomerById(customerId);
        CustomerDTO productDto = customerService.convertDTO(customer);
        return ResponseUtils.ok(productDto);
    }

    @GetMapping("/exits/{customerId}")
    public ResponseEntity<APIResponse> isCustomerExist(@PathVariable String customerId) {
        Boolean isCustomerExits = customerService.isCustomerExist(customerId);
        return ResponseUtils.ok(isCustomerExits);
    }

    @PostMapping()
    public ResponseEntity<APIResponse> createCustomer(@RequestBody @Valid CreateCustomerDTO createCustomerDTO) {
        Customer customer = customerService.createCustomer(createCustomerDTO);
        CustomerDTO customerDTO =  customerService.convertDTO(customer);
        return ResponseUtils.ok(customerDTO);
    }
    @PutMapping()
    public ResponseEntity<APIResponse> updateCustomer(@RequestBody UpdateCustomerDTO request, @PathVariable String customerId) {
        Customer customer = customerService.updateCustomer(request, customerId);
        CustomerDTO customerDTO = customerService.convertDTO(customer);
        return ResponseUtils.accepted(customerDTO);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<APIResponse> deleteCustomer(@PathVariable String customerId) {
        customerService.deleteCustomer(customerId);
        return ResponseUtils.ok(customerId);
    }


}
