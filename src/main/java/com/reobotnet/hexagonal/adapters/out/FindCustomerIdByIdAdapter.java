package com.reobotnet.hexagonal.adapters.out;

import com.reobotnet.hexagonal.adapters.out.mapper.CustomerEntityMapper;
import com.reobotnet.hexagonal.adapters.out.repository.CustomerRepository;
import com.reobotnet.hexagonal.aplication.core.domain.Customer;
import com.reobotnet.hexagonal.aplication.ports.out.FindCustomerByIdOutPutPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindCustomerIdByIdAdapter  implements FindCustomerByIdOutPutPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public Optional<Customer> find(String id) {
        var  customerEntity = customerRepository.findById(id);
        return customerEntity.map(
                entity -> customerEntityMapper.toCustomer(entity));
    }
}
