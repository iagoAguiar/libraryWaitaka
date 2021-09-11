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

    @NotNull(message = "Autor não pode ser vazio")
    private String autor;

    @NotNull(message = "Editora não pode ser vazio")
    private String editora;

    @NotNull(message = "Edição não pode ser vazio")
    private String edicao;

    @NotNull(message = "Dia do aluguel não pode ser vazio")
    private String diaAluguel;

    private String dataRenovacao;

    @NotNull(message = "Data de lançamento não pode ser vazio")
    private String lancamento;

    private Usuario locatario;

    DateTimeFormatter $format1 = DateTimeFormatter.ofPattern("dd/MM/yyy");



    public Aluguel(
            String autor,
            String editora,
            LocalDateTime diaAluguel,
            LocalDateTime lancamento,
            String edicao,
            Usuario locatario) {
        this.autor = autor;
        this.editora = editora;
        this.locatario = locatario;
        this.edicao = edicao.toString();
        this.lancamento = LocalDateTime.parse(lancamento.toString()).format($format1);
        this.diaAluguel = LocalDateTime.parse(diaAluguel.toString()).format($format1);


        defineTempoLocacao(locatario, diaAluguel.toString());
    }




    private void defineTempoLocacao(Usuario locatario, String diaAluguel) {
        switch (locatario.getProfile()){
            case ESTUDANTE:
                this.dataRenovacao = LocalDateTime.parse(diaAluguel).plusDays(7).format($format1);
                break;
            case FUNCIONARIO:
                this.dataRenovacao = LocalDateTime.parse(diaAluguel).plusDays(10).format($format1);
                break;
            case PROFESSOR:
                this.dataRenovacao = LocalDateTime.parse(diaAluguel).plusDays(14).format($format1);
                break;
        }
    }


}






