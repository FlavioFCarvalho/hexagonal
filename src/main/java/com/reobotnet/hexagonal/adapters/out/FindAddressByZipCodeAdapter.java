package com.reobotnet.hexagonal.adapters.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.reobotnet.hexagonal.adapters.out.client.FindAddressByZipCodeClient;
import com.reobotnet.hexagonal.adapters.out.client.mapper.AddressResponseMapper;
import com.reobotnet.hexagonal.aplication.core.domain.Address;
import com.reobotnet.hexagonal.aplication.ports.out.FindAddressByZipcodeOutPutPort;


@Component
public class FindAddressByZipCodeAdapter  implements FindAddressByZipcodeOutPutPort{

	
	@Autowired
	private FindAddressByZipCodeClient findAddressByZipCodeClient;
	
	@Autowired
	private AddressResponseMapper addressResponseMapper;
	
	@Override
	public Address find(String zipCode) {
		
		var addressResponse = findAddressByZipCodeClient.find(zipCode);
		return addressResponseMapper.toAddress(addressResponse);
	}

}
