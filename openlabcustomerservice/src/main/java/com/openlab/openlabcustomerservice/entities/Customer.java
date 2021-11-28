package com.openlab.openlabcustomerservice.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "customers")
@Data @NoArgsConstructor @AllArgsConstructor
public class Customer {
    @Id
    private String id;
    private String name;
    private String email;

}
