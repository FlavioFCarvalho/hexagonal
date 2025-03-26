package com.reobotnet.hexagonal.adapters.out;

import com.reobotnet.hexagonal.adapters.out.mapper.CustomerEntityMapper;
import com.reobotnet.hexagonal.adapters.out.repository.CustomerRepository;
import com.reobotnet.hexagonal.aplication.core.domain.Customer;
import com.reobotnet.hexagonal.aplication.ports.out.InsertCustomerOutPutPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertCustomerAdapter implements InsertCustomerOutPutPort{

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;


    @Override
    public void insert(Customer customer) {
        var customerEntity = customerEntityMapper.toCustomerEntity(customer);
       customerRepository.save(customerEntity);
    }
}
