package com.reobotnet.hexagonal.aplication.core.domain.usecase;

import com.reobotnet.hexagonal.aplication.core.domain.Customer;
import com.reobotnet.hexagonal.aplication.ports.in.FindCustomerByIdInputPort;
import com.reobotnet.hexagonal.aplication.ports.out.FindAddressByZipcodeOutPutPort;
import com.reobotnet.hexagonal.aplication.ports.out.UpdateCustomerOutputPort;

public class UpdaterCustomerUseCase {

    private final FindCustomerByIdInputPort findCustomerByIdInputPort;

    private final FindAddressByZipcodeOutPutPort findAddressByZipcodeOutPutPort;

    private final UpdateCustomerOutputPort updateCustomerOutputPort;

    public UpdaterCustomerUseCase(
            FindCustomerByIdInputPort findCustomerByIdInputPort,
            FindAddressByZipcodeOutPutPort findAddressByZipcodeOutPutPort,
            UpdateCustomerOutputPort updateCustomerOutputPort
    ) {
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.findAddressByZipcodeOutPutPort = findAddressByZipcodeOutPutPort;
        this.updateCustomerOutputPort = updateCustomerOutputPort;
    }

    public void update(Customer customer, String zipCoade) {
        findCustomerByIdInputPort.find(customer.getId());
        var address = findAddressByZipcodeOutPutPort.find(zipCoade);
        customer.setAddress(address);
        updateCustomerOutputPort.update(customer);
    }

}
