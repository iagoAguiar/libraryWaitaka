package com.waitakaLibrary.LibraryWaitaka;

import com.waitakaLibrary.LibraryWaitaka.Builder.UsuarioBuilder;
import com.waitakaLibrary.LibraryWaitaka.Entities.Aluguel;
import com.waitakaLibrary.LibraryWaitaka.Entities.Estudante;
import com.waitakaLibrary.LibraryWaitaka.Entities.Funcionario;
import com.waitakaLibrary.LibraryWaitaka.Entities.Professor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TestesAluguel {


    DateTimeFormatter $format1 = DateTimeFormatter.ofPattern("dd/MM/yyy");


    @Test
    void testeNovoAluguelEstudante() {

        Estudante estudante = UsuarioBuilder.builder().build().toEstudante();
        Aluguel aluguel = new Aluguel("Paulo Coelho", "Aleph",  LocalDateTime.now(), LocalDateTime.now(), "1 edição", estudante);
        assertEquals(aluguel.getAutor(), "Paulo Coelho");
        assertEquals(aluguel.getDiaAluguel(), LocalDateTime.parse(LocalDateTime.now().toString()).format($format1));
        assertEquals(aluguel.getDataRenovacao(), LocalDateTime.parse(LocalDateTime.now().plusDays(7).toString()).format($format1));
    }
    @Test
    void testeNovoAluguelFuncionario() {

        Funcionario funcionario = UsuarioBuilder.builder().build().toFuncionario();
        Aluguel aluguel = new Aluguel("Paulo Coelho", "Aleph",  LocalDateTime.now(), LocalDateTime.now(), "1 edição", funcionario);
        assertEquals(aluguel.getAutor(), "Paulo Coelho");
        assertEquals(aluguel.getDiaAluguel(), LocalDateTime.parse(LocalDateTime.now().toString()).format($format1));
        assertEquals(aluguel.getDataRenovacao(), LocalDateTime.parse(LocalDateTime.now().plusDays(10).toString()).format($format1));

    }
    @Test
    void testeNovoAluguelProfessor() {

        Professor professor = UsuarioBuilder.builder().build().toProfessor();
        Aluguel aluguel = new Aluguel("Paulo Coelho", "Aleph",  LocalDateTime.now(), LocalDateTime.now(), "1 edição", professor);
        assertEquals(aluguel.getAutor(), "Paulo Coelho");
        assertEquals(aluguel.getDiaAluguel(), LocalDateTime.parse(LocalDateTime.now().toString()).format($format1));
        assertEquals(aluguel.getDataRenovacao(), LocalDateTime.parse(LocalDateTime.now().plusDays(14).toString()).format($format1));
    }
}
