package com.codecool.shop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String jwtToken;
}
