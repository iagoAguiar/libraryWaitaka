package com.waitakaLibrary.LibraryWaitaka.Builder;

import com.waitakaLibrary.LibraryWaitaka.Entities.*;
import com.waitakaLibrary.LibraryWaitaka.Entities.Form.AluguelForm;
import lombok.Builder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Builder
public class AluguelBuilder {




     @Builder.Default
     Estudante estudante = UsuarioBuilder.builder().build().toEstudante();
     @Builder.Default
     Funcionario funcionario = UsuarioBuilder.builder().build().toFuncionario();
     @Builder.Default
     Professor professor = UsuarioBuilder.builder().build().toProfessor();

    @Builder.Default
     Livros livro = LivroBuilder.builder().build().toLivro();

public Aluguel toAlguelEstudante(){return new Aluguel(livro, estudante); };
public Aluguel toAluguelProfessor(){ return new Aluguel(livro,professor);};
public Aluguel toAluguelFuncionario(){ return new Aluguel(livro,funcionario);};

public AluguelForm toAluguelForm(){
    DateTimeFormatter format1 = DateTimeFormatter.ofPattern("dd/MM/yyy");
    return new AluguelForm(livro.getTitulo() ,funcionario.getEmail());};


}
