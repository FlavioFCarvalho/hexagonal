package com.reobotnet.hexagonal.aplication.core.domain.usecase;


import com.reobotnet.hexagonal.aplication.core.domain.Customer;
import com.reobotnet.hexagonal.aplication.core.exception.CustomerNotFoundException;
import com.reobotnet.hexagonal.aplication.core.util.MessageUtil;
import com.reobotnet.hexagonal.aplication.ports.in.FindCustomerByIdInputPort;
import com.reobotnet.hexagonal.aplication.ports.out.FindCustomerByIdOutPutPort;

public class FindCutomerByIdUseCase implements FindCustomerByIdInputPort {

    private final FindCustomerByIdOutPutPort findCustomerByIdOutPutPort;

    public FindCutomerByIdUseCase(FindCustomerByIdOutPutPort findCustomerByIdOutPutPort) {
        this.findCustomerByIdOutPutPort = findCustomerByIdOutPutPort;
    }

    @Override
    public Customer find(String id) {
        return findCustomerByIdOutPutPort.find(id)
                .orElseThrow(() -> new CustomerNotFoundException(
                        MessageUtil.getMessage("error.customer.not.found", id)
                ));
    }
}

