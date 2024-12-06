package com.hajuna.ecommerce.services;

import com.hajuna.ecommerce.constants.ErrorMessages;
import com.hajuna.ecommerce.dto.CustomerDTO;
import com.hajuna.ecommerce.dto.request.CreateCustomerDTO;
import com.hajuna.ecommerce.dto.request.UpdateCustomerDTO;
import com.hajuna.ecommerce.exceptions.AlreadyExistsException;
import com.hajuna.ecommerce.exceptions.NotFoundException;
import com.hajuna.ecommerce.models.Customer;
import com.hajuna.ecommerce.repositories.CustomerRepository;
import com.hajuna.ecommerce.services.interfaces.ICustomerService;
import org.modelmapper.ModelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService implements ICustomerService {
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;
    @Override
    public Customer getCustomerById(String customerId) {
        return customerRepository.findById(customerId).orElseThrow(() -> new NotFoundException(ErrorMessages.USER_NOT_FOUND));
    }

    @Override
    public Customer createCustomer(CreateCustomerDTO request) {
        if (customerRepository.existsByEmail(request.getEmail())) {
            throw new AlreadyExistsException(ErrorMessages.EMAIL_ALREADY_EXISTS);
        }
        Customer customer = Customer.builder()
                        .fistName(request.getFistName())
                        .lastName(request.getLastName())
                        .email(request.getEmail())
                        .phone(request.getPhone())
                        .address(request.getAddress())
                        .build();
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(UpdateCustomerDTO request, String customerId) {
        return  customerRepository.findById(customerId).map(existingCustomer -> {
            existingCustomer.setFistName(request.getFistName());
            existingCustomer.setLastName(request.getLastName());
            existingCustomer.setEmail(request.getEmail());
            existingCustomer.setPhone(request.getPhone());
            existingCustomer.setAddress(request.getAddress());
            return customerRepository.save(existingCustomer);
        }).orElseThrow(() -> new NotFoundException(ErrorMessages.USER_NOT_FOUND));
    }

    @Override
    public void deleteCustomer(String customerId) {
        customerRepository.findById(customerId).ifPresentOrElse(customerRepository :: delete, () -> {
            throw new NotFoundException(ErrorMessages.USER_NOT_FOUND);
        });
    }

    @Override
    public Boolean isCustomerExist(String customerId) {
        return customerRepository.existsById(customerId);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public CustomerDTO convertDTO(Customer customer) {
        return modelMapper.map(customer, CustomerDTO.class);
    }

    @Override
    public List<CustomerDTO> convertDTOList(List<Customer> customers) {
        return customers.stream().map(this::convertDTO).toList();
    }
}
