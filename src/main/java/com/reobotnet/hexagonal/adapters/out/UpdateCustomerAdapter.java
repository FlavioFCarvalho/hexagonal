package com.reobotnet.hexagonal.adapters.out;

import com.reobotnet.hexagonal.adapters.out.mapper.CustomerEntityMapper;
import com.reobotnet.hexagonal.adapters.out.repository.CustomerRepository;
import com.reobotnet.hexagonal.aplication.core.domain.Customer;
import com.reobotnet.hexagonal.aplication.ports.out.UpdateCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerAdapter implements UpdateCustomerOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public void update(Customer customer) {
        var customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);
    }
}
