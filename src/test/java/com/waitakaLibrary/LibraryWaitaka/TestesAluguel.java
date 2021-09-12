package com.waitakaLibrary.LibraryWaitaka;

import com.waitakaLibrary.LibraryWaitaka.Builder.AluguelBuilder;
import com.waitakaLibrary.LibraryWaitaka.Builder.UsuarioBuilder;
import com.waitakaLibrary.LibraryWaitaka.Entities.Aluguel;

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

        Aluguel aluguel = AluguelBuilder.builder().build().toAlguelEstudante();

        assertEquals(aluguel.getAutor(), "Paulo Coelho");
        assertEquals(aluguel.getDiaAluguel(), LocalDateTime.parse(LocalDateTime.now().toString()).format($format1));
        assertEquals(aluguel.getDataRenovacao(), LocalDateTime.parse(LocalDateTime.now().plusDays(7).toString()).format($format1));

    }
    @Test
    void testeNovoAluguelFuncionario() {

        Aluguel aluguel = AluguelBuilder.builder().build().toAluguelFuncionario();

        assertEquals(aluguel.getAutor(), "Paulo Coelho");
        assertEquals(aluguel.getDiaAluguel(), LocalDateTime.parse(LocalDateTime.now().toString()).format($format1));
        assertEquals(aluguel.getDataRenovacao(), LocalDateTime.parse(LocalDateTime.now().plusDays(10).toString()).format($format1));

    }
    @Test
    void testeNovoAluguelProfessor() {

        Aluguel aluguel = AluguelBuilder.builder().build().toAluguelProfessor();
        assertEquals(aluguel.getAutor(), "Paulo Coelho");
        assertEquals(aluguel.getDiaAluguel(), LocalDateTime.parse(LocalDateTime.now().toString()).format($format1));
        assertEquals(aluguel.getDataRenovacao(), LocalDateTime.parse(LocalDateTime.now().plusDays(14).toString()).format($format1));
    }
//
//    @Test
//    void testeMapeamentoDTO() {
//        Professor professor = UsuarioBuilder.builder().build().toProfessor();
//        //Aluguel aluguel = new Aluguel("O alquimista","Paulo Coelho", "Aleph",  LocalDateTime.now(), LocalDateTime.now(), "1 edição", professor);
//
//    }
//

    }
