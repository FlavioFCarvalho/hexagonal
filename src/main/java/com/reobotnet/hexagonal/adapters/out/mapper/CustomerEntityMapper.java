package com.reobotnet.hexagonal.adapters.out.mapper;

import com.reobotnet.hexagonal.adapters.out.entities.CustomerEntity;
import com.reobotnet.hexagonal.aplication.core.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {

    CustomerEntity toCustomerEntity(Customer customer);

    Customer toCustomer(CustomerEntity customerEntity);
}
