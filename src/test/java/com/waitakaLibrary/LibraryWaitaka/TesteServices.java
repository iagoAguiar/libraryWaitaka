package com.waitakaLibrary.LibraryWaitaka;

import com.waitakaLibrary.LibraryWaitaka.Builder.UsuarioBuilder;
import com.waitakaLibrary.LibraryWaitaka.Entities.DTO.EstudanteDTO;
import com.waitakaLibrary.LibraryWaitaka.Entities.Estudante;
import com.waitakaLibrary.LibraryWaitaka.Repository.EstudanteRepository;
import com.waitakaLibrary.LibraryWaitaka.Service.EstudanteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class TesteServices {


    @MockBean
    private EstudanteRepository estudanteRepository;

    @Autowired
    @MockBean
    private EstudanteService estudanteService;


    @Test
    void testeEstudanteServiceEService() {
        Estudante estudante = UsuarioBuilder.builder().build().toEstudante();
        EstudanteDTO estudanteDTO = new EstudanteDTO(estudante);
        Mockito.when(estudanteService.cadastrar(estudante)).thenReturn(estudanteDTO);
        Mockito.when(estudanteRepository.insert(estudante)).thenReturn(estudante);

    }

    @Test
    void testeEstudanteServoceComURI() {
        Estudante estudante = UsuarioBuilder.builder().build().toEstudante();
        EstudanteDTO estudanteDTO = new EstudanteDTO(estudante);
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString("api/v1/estudantes/{nome}");
        URI uri = UriComponentsBuilder.fromUriString("api/v1/estudantes/{nome}")
                .buildAndExpand(estudante.getNome()).toUri();

        Mockito.when(estudanteService.cadastrar(estudante, uriBuilder))
                .thenReturn(ResponseEntity.created(uri).body(estudanteDTO));
    }


}
