package com.waitakaLibrary.LibraryWaitaka.Builder;

import com.waitakaLibrary.LibraryWaitaka.Entities.Aluguel;
import com.waitakaLibrary.LibraryWaitaka.Entities.Estudante;
import com.waitakaLibrary.LibraryWaitaka.Entities.Form.AluguelForm;
import com.waitakaLibrary.LibraryWaitaka.Entities.Funcionario;
import com.waitakaLibrary.LibraryWaitaka.Entities.Professor;
import lombok.Builder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Builder
public class AluguelBuilder {



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
     @Builder.Default
     Estudante estudante = UsuarioBuilder.builder().build().toEstudante();
     @Builder.Default
     Funcionario funcionario = UsuarioBuilder.builder().build().toFuncionario();
     @Builder.Default
     Professor professor = UsuarioBuilder.builder().build().toProfessor();



public Aluguel toAlguelEstudante(){return new Aluguel(titulo,autor,editora,lancamento, edicao, estudante); };
public Aluguel toAluguelProfessor(){ return new Aluguel(titulo,autor,editora,lancamento, edicao,professor);};
public Aluguel toAluguelFuncionario(){ return new Aluguel(titulo,autor,editora,lancamento, edicao,funcionario);};

public AluguelForm toAluguelForm(){
    DateTimeFormatter format1 = DateTimeFormatter.ofPattern("dd/MM/yyy");
    return new AluguelForm(titulo,autor,editora,LocalDateTime.now().format(format1), lancamento, edicao,funcionario.getEmail());};


}