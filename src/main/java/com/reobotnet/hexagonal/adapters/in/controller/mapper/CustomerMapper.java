package com.reobotnet.hexagonal.adapters.in.controller.mapper;

import com.reobotnet.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.reobotnet.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.reobotnet.hexagonal.aplication.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "isValidCpf", ignore = true)
    Customer toCustomer(CustomerRequest customerRequest);

    CustomerResponse toCustomerResponse(Customer customer);
}
