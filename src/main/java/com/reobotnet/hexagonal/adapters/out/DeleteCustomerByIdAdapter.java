package com.reobotnet.hexagonal.adapters.out;

import com.reobotnet.hexagonal.adapters.out.repository.CustomerRepository;
import com.reobotnet.hexagonal.aplication.ports.out.DeleteCustomerByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerByIdAdapter implements DeleteCustomerByIdOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void delete(String id) {
        customerRepository.deleteById(id);
    }
}
