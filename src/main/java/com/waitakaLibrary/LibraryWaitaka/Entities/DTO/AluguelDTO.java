package com.waitakaLibrary.LibraryWaitaka.Entities.DTO;



import com.waitakaLibrary.LibraryWaitaka.Entities.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@Builder
@NoArgsConstructor
public class AluguelDTO {


    private String titulo;

    private String autor;

    private String editora;

    private String edicao;

    private String diaAluguel;

    private String dataRenovacao;

    private String lancamento;

    private Usuario usuario;




    public AluguelDTO(
            String titulo,
            String autor,
            String editora,
            String diaAluguel,
            String lancamento,
            String dataRenovacao,
            String edicao,
            Usuario usuario
            ) {
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.usuario = usuario;
        this.lancamento = lancamento;
        this.edicao = edicao;
        this.diaAluguel = diaAluguel;
        this.dataRenovacao = dataRenovacao;

    }

    public AluguelDTO(Aluguel aluguel){
        this.titulo = aluguel.getTitulo();
        this.autor = aluguel.getAutor();
        this.editora = aluguel.getEditora();
        this.edicao = aluguel.getEdicao();
        this.lancamento = aluguel.getLancamento();
        this.diaAluguel = aluguel.getDiaAluguel();
        this.dataRenovacao = aluguel.getDataRenovacao();
    }




}






