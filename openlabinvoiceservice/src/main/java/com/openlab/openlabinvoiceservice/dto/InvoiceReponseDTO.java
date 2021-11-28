package com.openlab.openlabinvoiceservice.dto;
import com.openlab.openlabinvoiceservice.entities.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceReponseDTO {
    private String id;
    private String customerId;
    private BigDecimal amount;
    private Customer customer;
}
