package com.openlab.openlabinvoiceservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="INVOICE")
public class Invoice {
    @Id
    private String id ;

    private String customerId;
    private BigDecimal amount;
    private Date date;

    @Transient
    private Customer customer;
}
