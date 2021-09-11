package com.waitakaLibrary.LibraryWaitaka.Entities;

import com.waitakaLibrary.LibraryWaitaka.Entities.Enums.Profile;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
public class Professor extends Usuario{

    @Id
    private String id;


    //@Indexed(unique = true)
    @NotNull(message = "Email não pode ser vazio")
    private String email;

    public Professor(
            String nome,
            String email,
            String telefone,
            Integer matricula,
            String CEP) {
        super(nome,telefone,matricula,CEP);
        this.profile = Profile.PROFESSOR;
        this.email = email;
    }



}
