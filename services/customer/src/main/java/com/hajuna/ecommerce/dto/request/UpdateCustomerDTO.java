package com.hajuna.ecommerce.dto.request;

import com.hajuna.ecommerce.models.Address;
import lombok.Data;

@Data
public class UpdateCustomerDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Address address;
}
