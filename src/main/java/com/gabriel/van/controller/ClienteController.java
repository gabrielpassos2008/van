package com.gabriel.van.controller;

import org.springframework.web.bind.annotation.RestController;

import com.gabriel.van.model.Cliente;
import com.gabriel.van.service.ClienteService;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping("/criarCliente")
    public ResponseEntity<?> postCriarUsuario(@RequestBody Cliente cliente) {
        if (clienteService.emailNaoExiste(cliente.getEmail())) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Email já cadastrado!");
        }
        Cliente cientecriado = clienteService.cadastrarCliente(cliente);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(cientecriado);
    }

    @GetMapping("/pesquisarCliente/{id}")
    public ResponseEntity<?> getPesquisarUsario(@PathVariable Long id) {
        Optional<Cliente> clientePesquisa = clienteService.pesquisarClientePorId(id);

        if (clientePesquisa.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(clientePesquisa);
        }
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("usuario do " + id + " nao existente no sistema");
        // return clienteService.pesquisarClientePorId(id);
    }

    @DeleteMapping("/excluirCliente/{id}")
    public ResponseEntity<?> deleteDeletarCliente(@PathVariable Long id) {
        Optional<Cliente> clientePesquisa = clienteService.pesquisarClientePorId(id);

        if (clientePesquisa.isPresent()) {
            clienteService.deletarCLientePorId(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("cliente deletado com sucesso!!");
        }

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("usuario do " + id + " nao existente no sistema");
    }

}
