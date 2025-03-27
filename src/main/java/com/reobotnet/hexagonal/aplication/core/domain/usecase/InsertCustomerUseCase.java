package com.reobotnet.hexagonal.aplication.core.domain.usecase;

import com.reobotnet.hexagonal.aplication.core.domain.Customer;
import com.reobotnet.hexagonal.aplication.ports.in.InsertCustomerInputPort;
import com.reobotnet.hexagonal.aplication.ports.out.FindAddressByZipcodeOutPutPort;
import com.reobotnet.hexagonal.aplication.ports.out.InsertCustomerOutPutPort;
import com.reobotnet.hexagonal.aplication.ports.out.SendCpfForValidationOutputPort;

public class InsertCustomerUseCase  implements InsertCustomerInputPort {
	
	private final FindAddressByZipcodeOutPutPort findAddressByZipcodeOutPutPort;
	
	private final InsertCustomerOutPutPort insertCustomerOutPutPort;

	private final SendCpfForValidationOutputPort sendCpfForValidationOutputPort;
	
	public InsertCustomerUseCase(
			FindAddressByZipcodeOutPutPort findAddressByZipcodeOutPutPort, 
			InsertCustomerOutPutPort insertCustomerOutPutPort,
			SendCpfForValidationOutputPort sendCpfForValidationOutputPort) {
		this.findAddressByZipcodeOutPutPort = findAddressByZipcodeOutPutPort;
		this.insertCustomerOutPutPort = insertCustomerOutPutPort;
		this.sendCpfForValidationOutputPort = sendCpfForValidationOutputPort;
	}
	
	@Override
	public void insert(Customer customer, String zipCode) {
		
		var address = findAddressByZipcodeOutPutPort.find(zipCode);
		customer.setAddress(address);
		insertCustomerOutPutPort.insert(customer);
		sendCpfForValidationOutputPort.send(customer.getCpf());
	}

}
