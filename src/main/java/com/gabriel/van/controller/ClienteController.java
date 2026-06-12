package com.gabriel.van.controller;

import org.springframework.web.bind.annotation.RestController;

import com.gabriel.van.model.Cliente;
import com.gabriel.van.service.ClienteService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }
    
    @PostMapping("/criarUsuario")
    public Cliente criarUsuario(@RequestBody Cliente cliente) {
        return clienteService.cadastrarCliente(cliente);
    }
    
}
