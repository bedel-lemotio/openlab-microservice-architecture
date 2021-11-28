package com.openlab.openlabinvoiceservice.services;



import com.openlab.openlabinvoiceservice.dto.InvoiceReponseDTO;
import com.openlab.openlabinvoiceservice.dto.InvoiceRequestDTO;

import java.util.List;

public interface InvoiceService {

    InvoiceReponseDTO save(InvoiceRequestDTO invoiceRequestDTO);

    InvoiceReponseDTO update(InvoiceRequestDTO invoiceRequestDTO);

    InvoiceReponseDTO getInvoice(String id);

    List<InvoiceReponseDTO> invoiceByCustomerId(String customerId);

    List<InvoiceReponseDTO> listInvoices();

}
