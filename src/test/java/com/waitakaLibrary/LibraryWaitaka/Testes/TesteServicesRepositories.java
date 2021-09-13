package com.waitakaLibrary.LibraryWaitaka.Testes;

import com.waitakaLibrary.LibraryWaitaka.Builder.UsuarioBuilder;
import com.waitakaLibrary.LibraryWaitaka.Entities.DTO.EstudanteDTO;
import com.waitakaLibrary.LibraryWaitaka.Entities.DTO.FuncionarioDTO;
import com.waitakaLibrary.LibraryWaitaka.Entities.DTO.ProfessorDTO;
import com.waitakaLibrary.LibraryWaitaka.Entities.Estudante;
import com.waitakaLibrary.LibraryWaitaka.Entities.Funcionario;
import com.waitakaLibrary.LibraryWaitaka.Entities.Professor;
import com.waitakaLibrary.LibraryWaitaka.Repository.EstudanteRepository;
import com.waitakaLibrary.LibraryWaitaka.Repository.FuncionarioRepository;
import com.waitakaLibrary.LibraryWaitaka.Repository.ProfessorRepository;
import com.waitakaLibrary.LibraryWaitaka.Service.EstudanteService;
import com.waitakaLibrary.LibraryWaitaka.Service.FuncionarioService;
import com.waitakaLibrary.LibraryWaitaka.Service.ProfessorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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
public class TesteServicesRepositories {


//    Estudante
    @MockBean
    private EstudanteRepository estudanteRepository;

    @Autowired
    @MockBean
    private EstudanteService estudanteService;

//    Professor

    @MockBean
    private ProfessorRepository professorRepository;

    @Autowired
    @MockBean
    private ProfessorService professorService;

//     Funcionario

    @MockBean
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    @MockBean
    private FuncionarioService funcionarioService;

    @Test
    void testeEstudanteServiceEService() {
        Estudante estudante = UsuarioBuilder.builder().build().toEstudante();
        EstudanteDTO estudanteDTO = new EstudanteDTO(estudante);
        Mockito.when(estudanteService.cadastrar(estudante)).thenReturn(estudanteDTO);
        Mockito.when(estudanteRepository.insert(estudante)).thenReturn(estudante);

    }

    @Test
    void testeEstudanteServiceComURI() {
        Estudante estudante = UsuarioBuilder.builder().build().toEstudante();
        EstudanteDTO estudanteDTO = new EstudanteDTO(estudante);
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString("api/v1/estudantes/{nome}");
        URI uri = UriComponentsBuilder.fromUriString("api/v1/estudantes/{nome}")
                .buildAndExpand(estudante.getNome()).toUri();

        Mockito.when(estudanteService.cadastrar(estudante, uriBuilder))
                .thenReturn(ResponseEntity.created(uri).body(estudanteDTO));
    }

    @Test
    void testeProfessorService() {
        Professor professor = UsuarioBuilder.builder().build().toProfessor();
        ProfessorDTO professorDTO = new ProfessorDTO(professor);
        Mockito.when(professorService.cadastrar(professor)).thenReturn(professorDTO);
        Mockito.when(professorRepository.insert(professor)).thenReturn(professor);

    }

    //    Professor


    @Test
    void testeProfessorServiceComURI() {
        Professor professor = UsuarioBuilder.builder().build().toProfessor();
        ProfessorDTO professorDTO = new ProfessorDTO(professor);
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString("api/v1/professores/{nome}");
        URI uri = UriComponentsBuilder.fromUriString("api/v1/professores/{nome}")
                .buildAndExpand(professor.getNome()).toUri();

        Mockito.when(professorService.cadastrar(professor, uriBuilder))
                .thenReturn(ResponseEntity.created(uri).body(professorDTO));
    }

    //     Funcionario


    @Test
    void testeFuncionarioService() {
        Funcionario funcionario = UsuarioBuilder.builder().build().toFuncionario();
        FuncionarioDTO funcionarioDTO = new FuncionarioDTO(funcionario);
        Mockito.when(funcionarioService.cadastrar(funcionario)).thenReturn(funcionarioDTO);
        Mockito.when(funcionarioRepository.insert(funcionario)).thenReturn(funcionario);

    }

    @Test
    void testeFuncionarioServiceComURI() {
        Funcionario funcionario = UsuarioBuilder.builder().build().toFuncionario();
        FuncionarioDTO funcionarioDTO = new FuncionarioDTO(funcionario);
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString("api/v1/funcionarios/{nome}");
        URI uri = UriComponentsBuilder.fromUriString("api/v1/funcionarios/{nome}")
                .buildAndExpand(funcionario.getNome()).toUri();

        Mockito.when(funcionarioService.cadastrar(funcionario, uriBuilder))
                .thenReturn(ResponseEntity.created(uri).body(funcionarioDTO));
    }


}
