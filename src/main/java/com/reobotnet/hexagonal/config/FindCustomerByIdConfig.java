package com.reobotnet.hexagonal.config;


import com.reobotnet.hexagonal.adapters.out.FindCustomerIdByIdAdapter;
import com.reobotnet.hexagonal.aplication.core.domain.usecase.FindCutomerByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCustomerByIdConfig {

    @Bean
    public FindCutomerByIdUseCase findCutomerByIdUseCase(
            FindCustomerIdByIdAdapter findCustomerByIdAdapter
    ) {
        return new FindCutomerByIdUseCase(findCustomerByIdAdapter);
    }
}