package com.hajuna.ecommerce.dto.response;

import com.hajuna.ecommerce.models.Address;
import lombok.Data;

@Data
public class CustomerResponseDTO {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Address address;
}
