package com.waitakaLibrary.LibraryWaitaka.Entities.Form;


import com.waitakaLibrary.LibraryWaitaka.Entities.Livro;
import lombok.Data;

@Data
public class LivroForm {



    private String titulo;

    private String autor;

    private String editora;

    private String edicao;

    private String lancamento;







    public LivroForm(
            String titulo,
            String autor,
            String editora,
            String lancamento,
            String edicao
    ) {
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.lancamento = lancamento;
        this.edicao = edicao;

    }
    public LivroForm(Livro livro){
        this.titulo = livro.getTitulo();
        this.autor = livro.getAutor();
        this.editora = livro.getEditora();
        this.lancamento = livro.getLancamento();
        this.edicao = livro.getEdicao();
    }

    public Livro toLivro(){
        return new Livro(
                this.titulo,
                this.autor,
                this.editora,
                this.lancamento,
                this.edicao
        );
    }





}
