package com.openlab.openlabinvoiceservice.mapper;

import com.openlab.openlabinvoiceservice.dto.InvoiceReponseDTO;
import com.openlab.openlabinvoiceservice.dto.InvoiceRequestDTO;
import com.openlab.openlabinvoiceservice.entities.Invoice;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-11-28T08:58:27+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_275 (AdoptOpenJDK)"
)
@Component
public class InvoiceMapperImpl implements InvoiceMapper {

    @Override
    public InvoiceReponseDTO invoiceToInvoiceReponseDTO(Invoice Invoice) {
        if ( Invoice == null ) {
            return null;
        }

        InvoiceReponseDTO invoiceReponseDTO = new InvoiceReponseDTO();

        invoiceReponseDTO.setId( Invoice.getId() );
        invoiceReponseDTO.setCustomerId( Invoice.getCustomerId() );
        invoiceReponseDTO.setAmount( Invoice.getAmount() );
        invoiceReponseDTO.setCustomer( Invoice.getCustomer() );

        return invoiceReponseDTO;
    }

    @Override
    public Invoice invoiceRequestDTOInvoice(InvoiceRequestDTO InvoiceRequestDTO) {
        if ( InvoiceRequestDTO == null ) {
            return null;
        }

        Invoice invoice = new Invoice();

        invoice.setCustomerId( InvoiceRequestDTO.getCustomerId() );
        invoice.setAmount( InvoiceRequestDTO.getAmount() );

        return invoice;
    }
}
