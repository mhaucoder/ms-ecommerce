package com.hajuna.ecommerce.dto.request;

import com.hajuna.ecommerce.models.Address;
import lombok.Data;

@Data
public class CreateCustomerDTO {
    private String fistName;
    private String lastName;
    private String email;
    private String phone;
    private Address address;
}
