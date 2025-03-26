package com.reobotnet.hexagonal.aplication.ports.in;

import com.reobotnet.hexagonal.aplication.core.domain.Customer;
import org.springframework.stereotype.Component;

@Component
public interface InsertCustomerInputPort {

    void insert(Customer customer, String zipCode);
}
