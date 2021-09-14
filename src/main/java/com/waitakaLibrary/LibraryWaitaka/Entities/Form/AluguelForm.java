package com.waitakaLibrary.LibraryWaitaka.Entities.Form;

import com.waitakaLibrary.LibraryWaitaka.Entities.Aluguel;
import com.waitakaLibrary.LibraryWaitaka.Entities.Usuario;
import lombok.Data;

@Data
public class AluguelForm {



    private String titulo;

    private String autor;

    private String editora;

    private String edicao;

    private String lancamento;

    private String emailusuario;





    public AluguelForm(
            String titulo,
            String autor,
            String editora,
            String diaAluguel,
            String lancamento,
            String edicao,
            String emailusuario
    ) {
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.emailusuario = emailusuario;
        this.lancamento = lancamento;
        this.edicao = edicao;

    }

public Aluguel toAluguel(Usuario usuario){
        return new Aluguel(
                this.titulo,
                this.autor,
                this.editora,
                this.lancamento,
                this.edicao,
                usuario
        );
}



}
