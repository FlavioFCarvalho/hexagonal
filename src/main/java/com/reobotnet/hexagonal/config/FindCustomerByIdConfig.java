package com.reobotnet.hexagonal.config;


import com.reobotnet.hexagonal.adapters.out.FindCustomerByIdAdapter;
import com.reobotnet.hexagonal.aplication.core.domain.usecase.FindCustomerByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCustomerByIdConfig {

    @Bean
    public FindCustomerByIdUseCase findCutomerByIdUseCase(
            FindCustomerByIdAdapter findCustomerByIdAdapter
    ) {
        return new FindCustomerByIdUseCase(findCustomerByIdAdapter);
    }
}