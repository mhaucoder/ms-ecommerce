package com.hajuna.ecommerce.dto;

import com.hajuna.ecommerce.models.Address;
import lombok.Data;

@Data
public class CustomerDTO {
    private String id;
    private String fistName;
    private String lastName;
    private String email;
    private String phone;
    private Address address;
}
