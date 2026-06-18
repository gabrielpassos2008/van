package com.gabriel.van.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// update atualiza os dados que o usuario informou
public class ClienteUpdateDTO {
    private String nome;
    private String  email;
}
