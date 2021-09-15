package com.waitakaLibrary.LibraryWaitaka.Entities;

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
    Livros livro;

    @NotNull(message = "Dia do aluguel não pode ser vazio")
    private String diaAluguel  = LocalDateTime.now().toString();
    private String dataRenovacao;

   private Usuario usuario;

    @PersistenceConstructor
    public Aluguel(
            Livros livro,
            Usuario usuario) {
        this.livro = livro;
        this.usuario = usuario;

        defineDatas(usuario, diaAluguel);
    }




    private void defineDatas(Usuario locatario, String diaAluguel) {

        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("dd/MM/yyy");

        switch (locatario.getProfile()){
            case ESTUDANTE:
                this.dataRenovacao = LocalDateTime.parse(diaAluguel).plusDays(7).format(format1);
                break;
            case FUNCIONARIO:
                this.dataRenovacao = LocalDateTime.parse(diaAluguel).plusDays(10).format(format1);
                break;
            case PROFESSOR:
                this.dataRenovacao = LocalDateTime.parse(diaAluguel).plusDays(14).format(format1);
                break;
        }
        this.diaAluguel = LocalDateTime.parse(diaAluguel).format(format1);

    }


}






