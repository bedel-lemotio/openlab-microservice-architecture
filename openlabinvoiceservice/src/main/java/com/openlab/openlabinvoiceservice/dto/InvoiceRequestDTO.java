package com.openlab.openlabinvoiceservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceRequestDTO {
    private String customerId;
    private BigDecimal amount;
}
