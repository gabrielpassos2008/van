package com.gabriel.van.controller;

import com.gabriel.van.dto.ClienteDTO;
import com.gabriel.van.dto.ClienteResponseDTO;
import com.gabriel.van.dto.motorista.MotoristaCreateDTO;
import com.gabriel.van.model.Cliente;
import com.gabriel.van.service.ClienteService;
import com.gabriel.van.service.MotoristaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/motorista")
public class MotoristaController {

    public final MotoristaService motoristaService;
    public final ClienteService clienteService;

    public MotoristaController(MotoristaService motoristaService, ClienteService clienteService){
        this.motoristaService = motoristaService;
        this.clienteService = clienteService;
    }
    @PostMapping("/cadastrarcliente")
    public ResponseEntity<?> PostCadastrarCliente(@RequestBody ClienteDTO dto){
        ClienteResponseDTO Cliente = clienteService.cadastrarCliente(dto);
        return ResponseEntity.status(HttpStatus.OK).body(Cliente);

    }
}
