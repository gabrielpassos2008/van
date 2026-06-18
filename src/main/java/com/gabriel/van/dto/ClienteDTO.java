package com.gabriel.van.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

// o normal recebe dados que o usuario envia para a api.
// id nao esta aqui por que a api que gera, nao o cliente que informa.
public class ClienteDTO {
    private String nome;
    private String email;
    private String senha;
}
