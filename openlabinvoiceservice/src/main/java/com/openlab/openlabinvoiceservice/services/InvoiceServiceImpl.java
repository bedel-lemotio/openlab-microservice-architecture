package com.openlab.openlabinvoiceservice.services;

import com.openlab.openlabinvoiceservice.dto.InvoiceReponseDTO;
import com.openlab.openlabinvoiceservice.dto.InvoiceRequestDTO;
import com.openlab.openlabinvoiceservice.entities.Customer;
import com.openlab.openlabinvoiceservice.entities.Invoice;
import com.openlab.openlabinvoiceservice.exception.CustomerNotFoundException;
import com.openlab.openlabinvoiceservice.mapper.InvoiceMapper;
import com.openlab.openlabinvoiceservice.services.InvoiceService;
import com.openlab.openlabinvoiceservice.repositories.InvoiceRepository;
import com.openlab.openlabinvoiceservice.web.CustomerRestClient;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
public class InvoiceServiceImpl implements InvoiceService {

    private InvoiceRepository invoiceRepository;
    private InvoiceMapper invoiceMapper;
    private CustomerRestClient customerRestClient;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository, InvoiceMapper invoiceMapper, CustomerRestClient customerRestClient) {
        this.invoiceRepository = invoiceRepository;
        this.invoiceMapper = invoiceMapper;
        this.customerRestClient = customerRestClient;
    }

    @Override
    public InvoiceReponseDTO save(InvoiceRequestDTO invoiceRequestDTO) {

//        Customer customer = null;
//        try {
//            customer = customerRestClient.getCustomer(invoiceRequestDTO.getCustomerId());
//
//        }catch (Exception e){
//            throw new CustomerNotFoundException("Customer not found");
//        }
//        Invoice invoice = new Invoice();
//        invoice.setId(invoiceRequestDTO.getId());
//        invoice.setAmount(invoiceRequestDTO.getAmount());
//        invoice.setDate(new Date());
//        invoice.setCustomerId(invoiceRequestDTO.getCustomerId());

//         Invoice saveInvoice = invoiceRepository.save(invoice);

//        InvoiceReponseDTO invoiceReponseDTO = new InvoiceReponseDTO();
//
//        invoiceReponseDTO.setId(saveInvoice.getId());
//        invoiceReponseDTO.setAmount(saveInvoice.getAmount());
//        invoiceReponseDTO.setCustomerId(saveInvoice.getCustomerId());
//        saveInvoice.setCustomer(customer);
//        return  invoiceReponseDTO;

        Invoice invoice = invoiceMapper.invoiceRequestDTOInvoice(invoiceRequestDTO);
        invoice.setDate(new Date());
        invoice.setId(UUID.randomUUID().toString());
        //invoice.setCustomer(customer);
        Invoice saveInvoice = invoiceRepository.save(invoice);
        return invoiceMapper.invoiceToInvoiceReponseDTO(saveInvoice);
    }


    @Override
    public InvoiceReponseDTO update(InvoiceRequestDTO invoiceRequestDTO) {
        Invoice invoice = invoiceMapper.invoiceRequestDTOInvoice(invoiceRequestDTO);
        Invoice updateInvoice = invoiceRepository.save(invoice);
        return invoiceMapper.invoiceToInvoiceReponseDTO(updateInvoice);
    }

    @Override
    public InvoiceReponseDTO getInvoice(String invoiceId) {
        Invoice invoice = invoiceRepository.findById(String.valueOf(invoiceId)).get();
        Customer customer = customerRestClient.getCustomer(invoice.getCustomerId());
        invoice.setCustomer(customer);
        return invoiceMapper.invoiceToInvoiceReponseDTO(invoice);
    }

    @Override
    public List<InvoiceReponseDTO> invoiceByCustomerId(String customerId) {
        List<Invoice> invoices = invoiceRepository.findByCustomerId(customerId);
        for (Invoice invoice:invoices){
            Customer customer = customerRestClient.getCustomer(invoice.getCustomerId());
            invoice.setCustomer(customer);
        }
        return invoices.stream().map(
                invoice->invoiceMapper.invoiceToInvoiceReponseDTO(invoice)
        ).collect(Collectors.toList());
    }

    @Override
    public List<InvoiceReponseDTO> listInvoices() {
        List<Invoice> invoices = invoiceRepository.findAll();
        for (Invoice invoice:invoices){
            Customer customer = customerRestClient.getCustomer(invoice.getCustomerId());
            invoice.setCustomer(customer);
        }
        return invoices.stream().map(
                invoice->invoiceMapper.invoiceToInvoiceReponseDTO(invoice)
        ).collect(Collectors.toList());
    }

}
