package com.waitakaLibrary.LibraryWaitaka.Builder;

import com.waitakaLibrary.LibraryWaitaka.Entities.Form.LivroForm;
import com.waitakaLibrary.LibraryWaitaka.Entities.Livros;
import lombok.Builder;

@Builder
public class LivroBuilder {

    @Builder.Default
    String titulo = "O alquimista";
    @Builder.Default
    String autor = "Paulo Coelho";
    @Builder.Default
    String editora = "Aleph";
    @Builder.Default
    String lancamento =  "12/04/1989";
    @Builder.Default
    String edicao= "1 edição";


    public Livros toLivro(){
        return new Livros(titulo,autor,editora,lancamento,edicao);
    }

    public LivroForm toLivroForm(){
        return new LivroForm(titulo,autor,editora,lancamento,edicao);
    }

}
