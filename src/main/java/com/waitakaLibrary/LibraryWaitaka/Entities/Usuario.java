package com.waitakaLibrary.LibraryWaitaka.Entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.index.Indexed;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
abstract class Usuario {
    @NotNull(message = "Nome não pode ser vazio")
    private String nome;
        @NotNull(message = "Telefone não pode ser vazio")
    private String telefone;
    @NotNull(message = "Matricula não pode ser vazio")
    private Integer matricula;
    @NotNull(message = "CEP não pode ser vazia")
    private String CEP;


}
