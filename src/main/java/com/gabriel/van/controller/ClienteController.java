package com.gabriel.van.controller;

import org.springframework.web.bind.annotation.RestController;

import com.gabriel.van.model.Cliente;
import com.gabriel.van.service.ClienteService;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }
    
    @PostMapping("/criarUsuario")
    public ResponseEntity<?> criarUsuario(@RequestBody Cliente cliente) {
        if (clienteService.emailNaoExiste(cliente.getEmail())) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Email já cadastrado!");
        }
        Cliente criado = clienteService.cadastrarCliente(cliente);
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(criado);
    }
    
}
