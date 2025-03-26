package com.reobotnet.hexagonal.aplication.ports.out;

import com.reobotnet.hexagonal.aplication.core.domain.Customer;

public interface UpdateCustomerOutputPort {

    void update(Customer customer);
}
