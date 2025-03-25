package com.reobotnet.hexagonal.adapters.out.client.mapper;

import org.mapstruct.Mapper;

import com.reobotnet.hexagonal.adapters.out.client.response.AddressResponse;
import com.reobotnet.hexagonal.aplication.core.domain.Address;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {
	
	Address toAddress(AddressResponse addressResponse );

}
