package com.reobotnet.hexagonal.aplication.ports.out;

public interface SendCpfForValidationOutputPort {

    void send(String cpf);

}