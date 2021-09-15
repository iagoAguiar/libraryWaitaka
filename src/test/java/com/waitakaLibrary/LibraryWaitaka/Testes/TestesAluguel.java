package com.waitakaLibrary.LibraryWaitaka.Testes;

import com.waitakaLibrary.LibraryWaitaka.Builder.AluguelBuilder;
import com.waitakaLibrary.LibraryWaitaka.Entities.Aluguel;

import com.waitakaLibrary.LibraryWaitaka.DTO.AluguelDTO;
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
        System.out.println(aluguel.getLivro().getAutor());
        assertEquals(aluguel.getLivro().getAutor(), "Paulo Coelho");
        assertEquals(aluguel.getDiaAluguel(), LocalDateTime.parse(LocalDateTime.now().toString()).format($format1));
        assertEquals(aluguel.getDataRenovacao(), LocalDateTime.parse(LocalDateTime.now().plusDays(7).toString()).format($format1));

    }
    @Test
    void testeNovoAluguelFuncionario() {

        Aluguel aluguel = AluguelBuilder.builder().build().toAluguelFuncionario();

        assertEquals(aluguel.getLivro().getAutor(), "Paulo Coelho");
        assertEquals(aluguel.getDiaAluguel(), LocalDateTime.parse(LocalDateTime.now().toString()).format($format1));
        assertEquals(aluguel.getDataRenovacao(), LocalDateTime.parse(LocalDateTime.now().plusDays(10).toString()).format($format1));

    }
    @Test
    void testeNovoAluguelProfessor() {

        Aluguel aluguel = AluguelBuilder.builder().build().toAluguelProfessor();
        assertEquals(aluguel.getLivro().getAutor(), "Paulo Coelho");
        assertEquals(aluguel.getDiaAluguel(), LocalDateTime.parse(LocalDateTime.now().toString()).format($format1));
        assertEquals(aluguel.getDataRenovacao(), LocalDateTime.parse(LocalDateTime.now().plusDays(14).toString()).format($format1));
    }

    @Test
    void testeMapeamentoDTO() {
        Aluguel aluguel = AluguelBuilder.builder().build().toAlguelEstudante();
        AluguelDTO aluguelDTO = new AluguelDTO(aluguel);

        assertEquals(aluguelDTO.getLivro().getTitulo(), "O alquimista");
        assertEquals(aluguelDTO.getLivro().getAutor(), "Paulo Coelho");


    }


    }
