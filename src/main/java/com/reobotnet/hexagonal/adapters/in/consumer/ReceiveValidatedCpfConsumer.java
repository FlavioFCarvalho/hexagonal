package com.reobotnet.hexagonal.adapters.in.consumer;


import com.reobotnet.hexagonal.adapters.in.consumer.mapper.CustomerMessageMapper;
import com.reobotnet.hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.reobotnet.hexagonal.aplication.ports.in.UpdateCustomerInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveValidatedCpfConsumer {

    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;

    @Autowired
    private CustomerMessageMapper customerMessageMapper;

    @KafkaListener(topics = "tp-cpf-validated", groupId = "arantes")
    public void receive(CustomerMessage customerMessage) {
        var customer = customerMessageMapper.toCustomer(customerMessage);
        updateCustomerInputPort.update(customer, customerMessage.getZipCode());
    }

}
