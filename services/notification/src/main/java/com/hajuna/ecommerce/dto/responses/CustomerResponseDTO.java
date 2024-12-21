package com.hajuna.ecommerce.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponseDTO {
    public String id;
    public String firstName;
    public String lastName;
    public String email;
    public String phone;
}
