package com.waitakaLibrary.LibraryWaitaka;

import com.waitakaLibrary.LibraryWaitaka.Builder.UsuarioBuilder;
import com.waitakaLibrary.LibraryWaitaka.Entities.Estudante;
import com.waitakaLibrary.LibraryWaitaka.Repository.EstudanteRepository;
import com.waitakaLibrary.LibraryWaitaka.Service.EstudanteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class TesteServices {

    @Mock
    private EstudanteRepository estudanteRepository;

    @InjectMocks
    private EstudanteService estudanteService;



    @Test
    void testeEstudanteRepository(){
        Estudante estudante = UsuarioBuilder.builder().build().toEstudante();

        Mockito.when(estudanteService.cadastrar(estudante)).thenReturn(estudante);
    }
}
