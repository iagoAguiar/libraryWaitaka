package com.waitakaLibrary.LibraryWaitaka.DTO;



import com.waitakaLibrary.LibraryWaitaka.Entities.*;
import com.waitakaLibrary.LibraryWaitaka.Entities.Enums.Profile;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
//@NoArgsConstructor
public class AluguelDTO {


    private LivroDTO livro;
    private String diaAluguel;
    private String dataRenovacao;
    private String usuarioNome;
    private Profile perfilUsuario;

    public AluguelDTO(
          LivroDTO livroDTO,
            String diaAluguel,
            String dataRenovacao,
            String usuarioNome,
          Profile perfilUsuario
            ) {
        this.livro = livroDTO;
        this.usuarioNome = usuarioNome;
        this.diaAluguel = diaAluguel;
        this.dataRenovacao = dataRenovacao;
        this.perfilUsuario = perfilUsuario;

    }

    public AluguelDTO(Aluguel aluguel){
        this.livro = new LivroDTO(aluguel.getLivro());
        this.diaAluguel = aluguel.getDiaAluguel();
        this.dataRenovacao = aluguel.getDataRenovacao();
        this.usuarioNome = aluguel.getUsuario().getNome();
        this.perfilUsuario = aluguel.getUsuario().getProfile();
    }
}






