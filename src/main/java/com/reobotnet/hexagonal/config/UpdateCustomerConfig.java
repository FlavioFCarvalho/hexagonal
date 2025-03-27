package com.reobotnet.hexagonal.config;


import com.reobotnet.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.reobotnet.hexagonal.adapters.out.UpdateCustomerAdapter;
import com.reobotnet.hexagonal.aplication.core.domain.usecase.FindCustomerByIdUseCase;
import com.reobotnet.hexagonal.aplication.core.domain.usecase.UpdateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {

    @Bean
    public UpdateCustomerUseCase updaterCustomerUseCase(
            FindCustomerByIdUseCase findCustomerByIdUseCase,
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            UpdateCustomerAdapter updateCustomerAdapter
    ) {
        return new UpdateCustomerUseCase(findCustomerByIdUseCase, findAddressByZipCodeAdapter, updateCustomerAdapter);
    }

}
