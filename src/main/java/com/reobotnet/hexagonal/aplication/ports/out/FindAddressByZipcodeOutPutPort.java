package com.reobotnet.hexagonal.aplication.ports.out;

import com.reobotnet.hexagonal.aplication.core.domain.Address;

public interface FindAddressByZipcodeOutPutPort {
	
	Address find(String zipCode);

}
