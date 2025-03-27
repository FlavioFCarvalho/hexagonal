package com.reobotnet.hexagonal.config;


import com.reobotnet.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.reobotnet.hexagonal.adapters.out.UpdateCustomerAdapter;
import com.reobotnet.hexagonal.aplication.core.domain.usecase.FindCutomerByIdUseCase;
import com.reobotnet.hexagonal.aplication.core.domain.usecase.UpdaterCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {

    @Bean
    public UpdaterCustomerUseCase updaterCustomerUseCase(
            FindCutomerByIdUseCase findCustomerByIdUseCase,
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            UpdateCustomerAdapter updateCustomerAdapter
    ) {
        return new UpdaterCustomerUseCase(findCustomerByIdUseCase, findAddressByZipCodeAdapter, updateCustomerAdapter);
    }

}
