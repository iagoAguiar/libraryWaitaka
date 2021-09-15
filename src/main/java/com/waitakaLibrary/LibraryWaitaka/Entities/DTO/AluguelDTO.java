package com.waitakaLibrary.LibraryWaitaka.Entities.DTO;



import com.waitakaLibrary.LibraryWaitaka.Entities.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@Builder
@NoArgsConstructor
public class AluguelDTO {


    private Livros livro;

    private String diaAluguel;

    private String dataRenovacao;



    private Usuario usuario;




    public AluguelDTO(
          Livros livro,
            String diaAluguel,
            String dataRenovacao,
            Usuario usuario
            ) {
        this.livro = livro;
        this.usuario = usuario;
        this.diaAluguel = diaAluguel;
        this.dataRenovacao = dataRenovacao;

    }

    public AluguelDTO(Aluguel aluguel){
        this.livro = aluguel.getLivro();
        this.diaAluguel = aluguel.getDiaAluguel();
        this.dataRenovacao = aluguel.getDataRenovacao();
    }




}






