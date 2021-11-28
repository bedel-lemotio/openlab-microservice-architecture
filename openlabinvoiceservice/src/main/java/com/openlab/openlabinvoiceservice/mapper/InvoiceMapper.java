package com.openlab.openlabinvoiceservice.mapper;


import com.openlab.openlabinvoiceservice.dto.InvoiceReponseDTO;
import com.openlab.openlabinvoiceservice.dto.InvoiceRequestDTO;
import com.openlab.openlabinvoiceservice.entities.Invoice;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {

    InvoiceReponseDTO invoiceToInvoiceReponseDTO(Invoice Invoice);

    Invoice invoiceRequestDTOInvoice(InvoiceRequestDTO InvoiceRequestDTO);
}
