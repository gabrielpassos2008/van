package com.gabriel.van.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

// o response serve para devolver dados ao usuario.
// senha nao esta aqui pq é dados sensivel.
public class ClienteResponseDTO {
    private Long id;
    private String nome;
    private String email;
}
