package com.gabriel.van.service;

import org.springframework.stereotype.Service;

import com.gabriel.van.model.Cliente;
import com.gabriel.van.repository.ClienteRepository;
@Service
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public Cliente cadastrarCliente(Cliente cliente){
        return repository.save(cliente);
    };

    public boolean emailNaoExiste(String email){
        //retorna true se o email ja existe
        return repository.findByEmail(email).isPresent();
    };
    
}
