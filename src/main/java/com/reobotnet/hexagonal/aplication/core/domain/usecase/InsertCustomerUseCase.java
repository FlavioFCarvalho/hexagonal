package com.reobotnet.hexagonal.aplication.core.domain.usecase;

import com.reobotnet.hexagonal.aplication.core.domain.Customer;
import com.reobotnet.hexagonal.aplication.ports.out.FindAddressByZipcodeOutPutPort;
import com.reobotnet.hexagonal.aplication.ports.out.InsertCustomerOutPutPort;

public class InsertCustomerUseCase {
	
	private final FindAddressByZipcodeOutPutPort findAddressByZipcodeOutPutPort;
	
	private final InsertCustomerOutPutPort insertCustomerOutPutPort;
	
	
	public InsertCustomerUseCase(
			FindAddressByZipcodeOutPutPort findAddressByZipcodeOutPutPort, 
			InsertCustomerOutPutPort insertCustomerOutPutPort) {
		this.findAddressByZipcodeOutPutPort = findAddressByZipcodeOutPutPort;
		this.insertCustomerOutPutPort = insertCustomerOutPutPort;
	}
	
	
	public void insert(Customer customer, String zipCode) {
		
		var address = findAddressByZipcodeOutPutPort.find(zipCode);
		customer.setAddress(address);
		insertCustomerOutPutPort.insert(customer);
	}

}
