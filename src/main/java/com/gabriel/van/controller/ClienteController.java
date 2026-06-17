package com.gabriel.van.controller;

import org.springframework.web.bind.annotation.RestController;

import com.gabriel.van.model.Cliente;
import com.gabriel.van.service.ClienteService;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;




@RestController

public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping("/criarcliente")
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

    @GetMapping("/pesquisarcliente/{id}")
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

    @GetMapping("/listarclientes")
    public ResponseEntity<?> getListarCliente() {
        List<Cliente> listaClientes = clienteService.retornarTodosCliente();
        if (!listaClientes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(listaClientes);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("nao existe cliente cadastrado");
    }
    

    @DeleteMapping("/excluircliente/{id}")
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

    @PutMapping("editarcliente/{id}")
    public ResponseEntity<?> putEditarCliente(@PathVariable Long id , @RequestBody Cliente clienteAntigo) {
        Optional<Cliente> clientePesquisa = clienteService.pesquisarClientePorId(id);
        
        if (clientePesquisa.isPresent()) {
            Cliente clienteNovo = clienteService.atualizarCliente(id, clienteAntigo);
            return ResponseEntity.status(HttpStatus.OK).body("usuario editado com sucesso!" + clienteNovo);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("usuario do " + id + " nao existente no sistema");
    }

}
