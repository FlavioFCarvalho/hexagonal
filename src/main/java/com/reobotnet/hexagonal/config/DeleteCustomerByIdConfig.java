package com.reobotnet.hexagonal.config;


import com.reobotnet.hexagonal.adapters.out.DeleteCustomerByIdAdaptar;
import com.reobotnet.hexagonal.aplication.core.domain.usecase.DeleteCustomerByIdUseCase;
import com.reobotnet.hexagonal.aplication.core.domain.usecase.FindCutomerByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerByIdConfig {

    @Bean
    public DeleteCustomerByIdUseCase deleteCustomerByIdUseCase(
            FindCutomerByIdUseCase findCustomerByIdUseCase,
            DeleteCustomerByIdAdaptar deleteCustomerByIdAdapter
    ) {
        return new DeleteCustomerByIdUseCase(findCustomerByIdUseCase, deleteCustomerByIdAdapter);
    }

}