package com.reobotnet.hexagonal.aplication.ports.in;

import org.springframework.web.bind.annotation.PathVariable;


public interface DeleteCustomerByIdInputPort {

    void delete(String id);

}