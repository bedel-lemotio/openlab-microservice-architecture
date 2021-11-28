package com.openlab.openlabinvoiceservice.web;

import com.openlab.openlabinvoiceservice.dto.InvoiceReponseDTO;
import com.openlab.openlabinvoiceservice.dto.InvoiceRequestDTO;
import com.openlab.openlabinvoiceservice.services.InvoiceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class InvoiceRestAPI {

    private InvoiceService invoiceService;

    public InvoiceRestAPI(InvoiceService invoiceService){
        this.invoiceService = invoiceService;
    }

    @GetMapping(path = "/invoicesByCustomer/{customerId}")
    public List<InvoiceReponseDTO> getInvoicesByCustomer(@PathVariable String customerId){
        return  invoiceService.invoiceByCustomerId(customerId);
    }

    @GetMapping(path = "/invoices/{id}")
    public InvoiceReponseDTO getInvoices(@PathVariable(name = "id") String invoiceId){
        return  invoiceService.getInvoice(invoiceId);
    }

    @PostMapping(path = "/invoices")
    public InvoiceReponseDTO save(@RequestBody InvoiceRequestDTO InvoiceRequestDTO){
        return  invoiceService.save(InvoiceRequestDTO);
    }

    @GetMapping(path = "/invoices")
    public List<InvoiceReponseDTO> allInvoices(){
        return  invoiceService.listInvoices();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> expentionHandler(Exception e){
        return new  ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
