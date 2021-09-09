package com.waitakaLibrary.LibraryWaitaka.Builder;

import com.waitakaLibrary.LibraryWaitaka.Entities.Estudante;
import com.waitakaLibrary.LibraryWaitaka.Entities.Funcionario;
import com.waitakaLibrary.LibraryWaitaka.Entities.Professor;
import lombok.Builder;

@Builder
public class UsuarioBuilder {

    @Builder.Default
    String nome = "Iago";
    @Builder.Default
    String email = "iagoaguiar202@gmail.com";
    @Builder.Default
    String telefone = "22 9 9999-9999";
    @Builder.Default
    Integer matricula = 1234;
    @Builder.Default
    String CEP = "28240-965";


    public Estudante toEstudante(){ return new Estudante(nome,email,telefone,matricula, CEP);};
    public Funcionario toFuncionario(){ return new Funcionario(nome,email,telefone,matricula, CEP);};
    public Professor toProfessor(){ return new Professor(nome,email,telefone,matricula, CEP);};


}
