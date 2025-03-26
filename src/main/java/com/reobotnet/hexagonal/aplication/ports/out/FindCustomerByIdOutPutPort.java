package com.reobotnet.hexagonal.aplication.ports.out;

import com.reobotnet.hexagonal.aplication.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerByIdOutPutPort {

    Optional<Customer> find(String id);
}
