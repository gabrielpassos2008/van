package com.gabriel.van.dto.motorista;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MotoristaResponseDTO {
    private Long id;
    private String nome;
    private String email;
}
