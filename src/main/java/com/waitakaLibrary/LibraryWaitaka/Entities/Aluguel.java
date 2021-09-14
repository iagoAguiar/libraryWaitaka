package com.waitakaLibrary.LibraryWaitaka.Entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
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

    @NotNull(message = "Titulo não pode ser vazio")
    String titulo;

    @NotNull(message = "Autor não pode ser vazio")
    private String autor;

    @NotNull(message = "Editora não pode ser vazio")
    private String editora;

    @NotNull(message = "Edição não pode ser vazio")
    private String edicao;

    @NotNull(message = "Dia do aluguel não pode ser vazio")
    private String diaAluguel  = LocalDateTime.now().toString();

    private String dataRenovacao;

    @NotNull(message = "Data de lançamento não pode ser vazio")
    private String lancamento;


   private Usuario usuario;


    public Aluguel(
            String titulo,
            String autor,
            String editora,
            String lancamento,
            String edicao,
            Usuario usuario) {
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.usuario = usuario;
        this.edicao = edicao;
        this.lancamento = lancamento;


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






