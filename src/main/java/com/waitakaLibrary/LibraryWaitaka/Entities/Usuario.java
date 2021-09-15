package com.waitakaLibrary.LibraryWaitaka.Entities;


import com.waitakaLibrary.LibraryWaitaka.Entities.Enums.Perfil;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


@NoArgsConstructor
@Data
public abstract class Usuario {
    @NotNull(message = "Nome não pode ser vazio")
    private String nome;
    @NotNull(message = "Telefone não pode ser vazio")
    private String telefone;
    @NotNull(message = "Matricula não pode ser vazio")
    private Integer matricula;
    @NotNull(message = "CEP não pode ser vazia")
    private String CEP;

    protected Perfil profile;

    public Usuario(String nome, String telefone, Integer matricula, String CEP) {
        this.nome = nome;
        this.telefone = telefone;
        this.matricula = matricula;
        this.CEP = CEP;
    }


}
