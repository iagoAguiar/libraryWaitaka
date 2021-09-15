package com.waitakaLibrary.LibraryWaitaka.Builder;

import com.waitakaLibrary.LibraryWaitaka.Entities.Form.LivroForm;
import com.waitakaLibrary.LibraryWaitaka.Entities.Livro;
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


    public Livro toLivro(){
        return new Livro(titulo,autor,editora,lancamento,edicao);
    }

    public LivroForm toLivroForm(){
        return new LivroForm(titulo,autor,editora,lancamento,edicao);
    }

}
