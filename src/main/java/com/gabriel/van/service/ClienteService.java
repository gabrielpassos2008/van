package com.gabriel.van.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabriel.van.model.Cliente;
import com.gabriel.van.repository.ClienteRepository;
@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Cliente cadastrarCliente(Cliente cliente){
        return repository.save(cliente);
    };

    
}
