package com.waitakaLibrary.LibraryWaitaka.DTO;


import com.waitakaLibrary.LibraryWaitaka.Entities.Livro;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LivroDTO {

    private String titulo;

    private String autor;

    private String editora;

    private String edicao;

    private String lancamento;

    public LivroDTO(Livro livro){
        this.titulo = livro.getTitulo();
        this.autor = livro.getAutor();
        this.editora = livro.getEditora();
        this.edicao = livro.getEdicao();
        this.lancamento = livro.getLancamento();
    }

}
