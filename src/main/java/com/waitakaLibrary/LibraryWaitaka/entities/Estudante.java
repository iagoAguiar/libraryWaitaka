package com.waitakaLibrary.LibraryWaitaka.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;


@Data
@NoArgsConstructor
public class Estudante extends Usuario{

    @Id
    private Long id;

    private Profile profile = Profile.ESTUDANTE;

    //Construtor com parâmetros

    public Estudante(
            String nome,
            String email,
            String telefone,
            Integer matricula,
            String CEP) {
        super(nome, email, telefone,matricula,CEP);
    }



}