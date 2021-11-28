package com.openlab.openlabcustomerservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class CustomerRequestDTO {
    private String id;
    private String name;
    private String email;

    public CustomerRequestDTO(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
