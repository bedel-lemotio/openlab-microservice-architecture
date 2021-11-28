package com.openlab.openlabcustomerservice.mappers;


import com.openlab.openlabcustomerservice.dto.CustomerRequestDTO;
import com.openlab.openlabcustomerservice.dto.CustomerResponseDTO;
import com.openlab.openlabcustomerservice.entities.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
   CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

   CustomerResponseDTO customerToCustomerResponseDTO(Customer customer);
   Customer customerRequestDTOCustomer(CustomerRequestDTO customerRequestDTO);
}
