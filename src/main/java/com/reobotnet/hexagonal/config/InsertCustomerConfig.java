package com.reobotnet.hexagonal.config;

import com.reobotnet.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.reobotnet.hexagonal.adapters.out.InsertCustomerAdapter;
import com.reobotnet.hexagonal.aplication.core.domain.usecase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            InsertCustomerAdapter insertCustomerAdapter
    ) {
        return new InsertCustomerUseCase(findAddressByZipCodeAdapter,insertCustomerAdapter);
    }

}
