package com.waitakaLibrary.LibraryWaitaka.Entities;

import com.waitakaLibrary.LibraryWaitaka.Entities.Enums.Perfil;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Data
@NoArgsConstructor
@Document
public class Aluguel {

    @Id
    private String id;

    @Indexed(unique = true)
    @NotNull(message = "Livro não pode ser vazio")
    Livro livro;

    @NotNull(message = "Dia do aluguel não pode ser vazio")
    private String diaAluguel  = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyy"));

    private String dataRenovacao;

   private Usuario usuario;



    @PersistenceConstructor
    public Aluguel(
            Livro livro,
            Usuario usuario) {
        this.livro = livro;
        this.usuario = usuario;
        this.dataRenovacao = Perfil.defineDatas(usuario);
    }


}






