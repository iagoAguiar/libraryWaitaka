package com.waitakaLibrary.LibraryWaitaka.Entities;

import com.waitakaLibrary.LibraryWaitaka.Entities.Enums.Profile;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@Document
public class Estudante extends Usuario{



    @Id
    private String id;


    //@Indexed(unique = true)
    @NotNull(message = "Email não pode ser vazio")
    private String email;

    //Construtor com parâmetros
    @PersistenceConstructor
    public Estudante(
            String nome,
            String email,
            String telefone,
            Integer matricula,
            String CEP) {
        super(nome, telefone,matricula,CEP);
        this.email = email;
        this.profile = Profile.ESTUDANTE;

    }



}
