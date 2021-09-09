package com.waitakaLibrary.LibraryWaitaka;

import com.waitakaLibrary.LibraryWaitaka.Entities.Estudante;
import com.waitakaLibrary.LibraryWaitaka.Entities.Funcionario;
import com.waitakaLibrary.LibraryWaitaka.Entities.Professor;
import com.waitakaLibrary.LibraryWaitaka.Entities.Enums.Profile;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TestesEntidades {

    @Test
    void testeNovoEstudante() {

        Estudante estudante = new Estudante(
                "Iago",
                "iagoaguiar202@gmail.com",
                "22 9 9999-9999",
                1234,
                "28240-965" );
        assertEquals(estudante.getNome(), "Iago");
        assertEquals(estudante.getMatricula(), 1234);
        assertEquals(estudante.getTelefone(), "22 9 9999-9999");
        assertEquals(estudante.getEmail(), "iagoaguiar202@gmail.com");
        assertEquals(estudante.getCEP(), "28240-965");
        assertEquals(estudante.getProfile(), Profile.ESTUDANTE);



    }

    @Test
    void testeNovoProfessor() {
        Professor professor = new Professor(
                "Iago",
                "iagoaguiar202@gmail.com",
                "22 9 9999-9999",
                1234,
                "28240-965" );
        assertEquals(professor.getNome(), "Iago");
        assertEquals(professor.getMatricula(), 1234);
        assertEquals(professor.getTelefone(), "22 9 9999-9999");
        assertEquals(professor.getEmail(), "iagoaguiar202@gmail.com");
        assertEquals(professor.getCEP(), "28240-965");
        assertEquals(professor.getProfile(), Profile.PROFESSOR);
    }

    @Test
    void testeNovoFuncionario() {
        Funcionario funcionario = new Funcionario(
                "Iago",
                "iagoaguiar202@gmail.com",
                "22 9 9999-9999",
                1234,
                "28240-965" );
        assertEquals(funcionario.getNome(), "Iago");
        assertEquals(funcionario.getMatricula(), 1234);
        assertEquals(funcionario.getTelefone(), "22 9 9999-9999");
        assertEquals(funcionario.getEmail(), "iagoaguiar202@gmail.com");
        assertEquals(funcionario.getCEP(), "28240-965");
        assertEquals(funcionario.getProfile(), Profile.FUNCIONARIO);
    }
}
