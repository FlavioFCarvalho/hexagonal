package com.reobotnet.hexagonal.aplication.ports.in;

import com.reobotnet.hexagonal.aplication.core.domain.Customer;

public interface FindCustomerByIdInputPort {

    Customer find(String id);
}
