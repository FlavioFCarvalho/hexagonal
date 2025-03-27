package com.reobotnet.hexagonal.config;


import com.reobotnet.hexagonal.adapters.out.DeleteCustomerByIdAdapter;
import com.reobotnet.hexagonal.aplication.core.domain.usecase.DeleteCustomerByIdUseCase;
import com.reobotnet.hexagonal.aplication.core.domain.usecase.FindCustomerByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerByIdConfig {

    @Bean
    public DeleteCustomerByIdUseCase deleteCustomerByIdUseCase(
            FindCustomerByIdUseCase findCustomerByIdUseCase,
            DeleteCustomerByIdAdapter deleteCustomerByIdAdapter
    ) {
        return new DeleteCustomerByIdUseCase(findCustomerByIdUseCase, deleteCustomerByIdAdapter);
    }

}