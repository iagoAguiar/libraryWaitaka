package com.waitakaLibrary.LibraryWaitaka.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class Estudante {
    private Long id;
    @Id
    @NotNull(message = "Nome não pode ser vazio")
    private String nome;
    @NotNull(message = "Email não pode ser vazio")
    private String email;
    @NotNull(message = "Email não pode ser vazio")
    private String telefone;
    @NotNull(message = "Email não pode ser vazio")
    private Integer matricula;
    @NotNull(message = "CEP não pode ser vazia")
    private String CEP;

    //Construtor  com parâmetros



    public Estudante(String nome, String email, String telefone, Integer matricula, String CEP) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.matricula = matricula;
        this.CEP = CEP;
    }
}
