package com.waitakaLibrary.LibraryWaitaka.Builder;

import com.waitakaLibrary.LibraryWaitaka.Entities.Aluguel;
import com.waitakaLibrary.LibraryWaitaka.Entities.Estudante;
import com.waitakaLibrary.LibraryWaitaka.Entities.Funcionario;
import com.waitakaLibrary.LibraryWaitaka.Entities.Professor;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public class AluguelBuilder {

    @Builder.Default
    String titulo = "O alquimista";
    @Builder.Default
    String autor = "Paulo Coelho";
    @Builder.Default
    String editora = "Aleph";
    @Builder.Default
    LocalDateTime diaAluguel = LocalDateTime.now();
    @Builder.Default
    LocalDateTime lancamento = LocalDateTime.now();
     @Builder.Default
    String edicao= "1 edição";
     @Builder.Default
     Estudante estudante = UsuarioBuilder.builder().build().toEstudante();
     @Builder.Default
     Professor professor = UsuarioBuilder.builder().build().toProfessor();
     @Builder.Default
     Funcionario funcionario = UsuarioBuilder.builder().build().toFuncionario();

public Aluguel toAlguelEstudante(){ return new Aluguel(titulo,autor,editora,diaAluguel,lancamento, edicao,estudante);};
public Aluguel toAluguelProfessor(){ return new Aluguel(titulo,autor,editora,diaAluguel,lancamento, edicao,professor);};
public Aluguel toAluguelFuncionario(){ return new Aluguel(titulo,autor,editora,diaAluguel,lancamento, edicao,funcionario);};


}
