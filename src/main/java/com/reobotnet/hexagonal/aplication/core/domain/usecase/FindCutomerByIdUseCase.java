package com.reobotnet.hexagonal.aplication.core.domain.usecase;


import com.reobotnet.hexagonal.aplication.core.domain.Customer;
import com.reobotnet.hexagonal.aplication.core.exception.CustomerNotFoundException;
import com.reobotnet.hexagonal.aplication.core.util.MessageUtil;
import com.reobotnet.hexagonal.aplication.ports.out.FindCustomerByIdOutPutPort;

public class FindCutomerByIdUseCase {

    private final FindCustomerByIdOutPutPort findCustomerByIdOutPutPort;

    public FindCutomerByIdUseCase(FindCustomerByIdOutPutPort findCustomerByIdOutPutPort) {
        this.findCustomerByIdOutPutPort = findCustomerByIdOutPutPort;
    }

    public Customer find(String id) {
        return findCustomerByIdOutPutPort.find(id)
                .orElseThrow(() -> new CustomerNotFoundException(
                        MessageUtil.getMessage("error.customer.not.found", id)
                ));
    }
}

