package com.waitakaLibrary.LibraryWaitaka;

import com.waitakaLibrary.LibraryWaitaka.Builder.UsuarioBuilder;
import com.waitakaLibrary.LibraryWaitaka.Entities.Aluguel;
import com.waitakaLibrary.LibraryWaitaka.Entities.Estudante;
import com.waitakaLibrary.LibraryWaitaka.Entities.Funcionario;
import com.waitakaLibrary.LibraryWaitaka.Entities.Professor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TestesAluguel {



    @Test
    void testeNovoAluguelEstudante() {

        Estudante estudante = UsuarioBuilder.builder().build().toEstudante();
        Aluguel aluguel = new Aluguel("Paulo Coelho", "Aleph",  LocalDateTime.now(), LocalDateTime.now(), "1 edição", estudante);
        assertEquals(aluguel.getAutor(), "Paulo Coelho");
        assertEquals(aluguel.getDiaAluguel(), "10/09/2021");
        assertEquals(aluguel.getDataRenovacao(), "17/09/2021");
    }
    @Test
    void testeNovoAluguelFuncionario() {

        Funcionario funcionario = UsuarioBuilder.builder().build().toFuncionario();
        Aluguel aluguel = new Aluguel("Paulo Coelho", "Aleph",  LocalDateTime.now(), LocalDateTime.now(), "1 edição", funcionario);
        assertEquals(aluguel.getAutor(), "Paulo Coelho");
        assertEquals(aluguel.getDiaAluguel(), "10/09/2021");
        assertEquals(aluguel.getDataRenovacao(), "20/09/2021");

    }
    @Test
    void testeNovoAluguelProfessor() {

        Professor professor = UsuarioBuilder.builder().build().toProfessor();
        Aluguel aluguel = new Aluguel("Paulo Coelho", "Aleph",  LocalDateTime.now(), LocalDateTime.now(), "1 edição", professor);
        assertEquals(aluguel.getAutor(), "Paulo Coelho");
        assertEquals(aluguel.getDiaAluguel(), "10/09/2021");
        assertEquals(aluguel.getDataRenovacao(), "24/09/2021");
    }
}
