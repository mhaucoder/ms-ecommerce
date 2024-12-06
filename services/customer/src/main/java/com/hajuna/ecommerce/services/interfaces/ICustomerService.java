package com.hajuna.ecommerce.services.interfaces;

import com.hajuna.ecommerce.dto.CustomerDTO;
import com.hajuna.ecommerce.dto.request.CreateCustomerDTO;
import com.hajuna.ecommerce.dto.request.UpdateCustomerDTO;
import com.hajuna.ecommerce.models.Customer;

import java.util.List;

public interface ICustomerService {
    Customer getCustomerById(String customerId);
    Customer createCustomer(CreateCustomerDTO request);
    Customer updateCustomer(UpdateCustomerDTO request, String customerId);
    void deleteCustomer(String customerId);
    Boolean isCustomerExist(String customerId);
    List<Customer> getAllCustomers();
    CustomerDTO convertDTO(Customer customer);
    List<CustomerDTO> convertDTOList(List<Customer> customers);
}
