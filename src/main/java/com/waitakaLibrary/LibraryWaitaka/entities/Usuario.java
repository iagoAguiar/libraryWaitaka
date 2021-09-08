package com.waitakaLibrary.LibraryWaitaka.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
abstract class Usuario {
    @NotNull(message = "Nome não pode ser vazio")
    private String nome;
    @NotNull(message = "Email não pode ser vazio")
    private String email;
    @NotNull(message = "Telefone não pode ser vazio")
    private String telefone;
    @NotNull(message = "Matricula não pode ser vazio")
    private Integer matricula;
    @NotNull(message = "CEP não pode ser vazia")
    private String CEP;


}
