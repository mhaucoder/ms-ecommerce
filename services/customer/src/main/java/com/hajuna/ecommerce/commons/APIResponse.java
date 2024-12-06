package com.hajuna.ecommerce.commons;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter @Setter @ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class APIResponse {
    private Integer code;
    private String status;
    private String message;
    private Object data;
}
