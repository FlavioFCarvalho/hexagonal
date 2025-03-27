package com.reobotnet.hexagonal.aplication.core.domain.usecase;

import com.reobotnet.hexagonal.aplication.core.domain.Customer;
import com.reobotnet.hexagonal.aplication.ports.in.FindCustomerByIdInputPort;
import com.reobotnet.hexagonal.aplication.ports.in.UpdateCustomerInputPort;
import com.reobotnet.hexagonal.aplication.ports.out.FindAddressByZipcodeOutPutPort;
import com.reobotnet.hexagonal.aplication.ports.out.UpdateCustomerOutputPort;

public class UpdateCustomerUseCase implements UpdateCustomerInputPort {

    private final FindCustomerByIdInputPort findCustomerByIdInputPort;

    private final FindAddressByZipcodeOutPutPort findAddressByZipcodeOutPutPort;

    private final UpdateCustomerOutputPort updateCustomerOutputPort;

    public UpdateCustomerUseCase(
            FindCustomerByIdInputPort findCustomerByIdInputPort,
            FindAddressByZipcodeOutPutPort findAddressByZipcodeOutPutPort,
            UpdateCustomerOutputPort updateCustomerOutputPort
    ) {
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.findAddressByZipcodeOutPutPort = findAddressByZipcodeOutPutPort;
        this.updateCustomerOutputPort = updateCustomerOutputPort;
    }

     @Override
    public void update(Customer customer, String zipCoade) {
        findCustomerByIdInputPort.find(customer.getId());
        var address = findAddressByZipcodeOutPutPort.find(zipCoade);
        customer.setAddress(address);
        updateCustomerOutputPort.update(customer);
    }

}
