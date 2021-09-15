package com.waitakaLibrary.LibraryWaitaka.Entities;

import com.waitakaLibrary.LibraryWaitaka.Entities.Enums.Perfil;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@Document
public class Professor extends Usuario{

    @Id
    private String id;


    @Indexed(unique = true)
    @NotNull(message = "Email não pode ser vazio")
    private String email;

    @PersistenceConstructor
    public Professor(
            String nome,
            String email,
            String telefone,
            Integer matricula,
            String CEP) {
        super(nome,telefone,matricula,CEP);
        this.profile = Perfil.PROFESSOR;
        this.email = email;
    }



}
