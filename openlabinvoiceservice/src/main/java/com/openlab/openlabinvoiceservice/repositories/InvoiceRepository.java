package com.openlab.openlabinvoiceservice.repositories;

import com.openlab.openlabinvoiceservice.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, String> {

    //List<Invoice> findCustomerById(String customerId);

    List<Invoice> findByCustomerId(String customerId);

}
