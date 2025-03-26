package com.reobotnet.hexagonal.aplication.ports.in;

import com.reobotnet.hexagonal.aplication.core.domain.Customer;

public interface UpdateCustomerInputPort {

    void update(Customer customer, String zipCode);
}
