package com.waitakaLibrary.LibraryWaitaka.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;


@Data
@NoArgsConstructor
public class Professor extends Usuario{

    @Id
    private Long id;

    private Profile profile = Profile.PROFESSOR;

    //Construtor com parâmetros

    public Professor(
            String nome,
            String email,
            String telefone,
            Integer matricula,
            String CEP) {
        super(nome, email, telefone,matricula,CEP);
    }



}
