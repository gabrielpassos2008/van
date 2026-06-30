package com.gabriel.van.controller;

import com.gabriel.van.service.ClienteService;
import com.gabriel.van.service.MotoristaService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MotoristaController {

    public final MotoristaService motoristaService;
    public final ClienteService clienteService;

    public MotoristaController(MotoristaService motoristaService, ClienteService clienteService){
        this.motoristaService = motoristaService;
        this.clienteService = clienteService;
    }
}
