package com.waitakaLibrary.LibraryWaitaka.Testes;

import com.waitakaLibrary.LibraryWaitaka.Builder.AluguelBuilder;
import com.waitakaLibrary.LibraryWaitaka.Builder.UsuarioBuilder;
import com.waitakaLibrary.LibraryWaitaka.Entities.Aluguel;
import com.waitakaLibrary.LibraryWaitaka.DTO.AluguelDTO;
import com.waitakaLibrary.LibraryWaitaka.DTO.EstudanteDTO;
import com.waitakaLibrary.LibraryWaitaka.DTO.FuncionarioDTO;
import com.waitakaLibrary.LibraryWaitaka.DTO.ProfessorDTO;
import com.waitakaLibrary.LibraryWaitaka.Entities.Estudante;
import com.waitakaLibrary.LibraryWaitaka.Entities.Form.AluguelForm;
import com.waitakaLibrary.LibraryWaitaka.Entities.Funcionario;
import com.waitakaLibrary.LibraryWaitaka.Entities.Professor;
import com.waitakaLibrary.LibraryWaitaka.Exceptions.LivroNaoLocalizadoException;
import com.waitakaLibrary.LibraryWaitaka.Exceptions.UsuarioNaoEncontradoException;
import com.waitakaLibrary.LibraryWaitaka.Repository.EstudanteRepository;
import com.waitakaLibrary.LibraryWaitaka.Repository.FuncionarioRepository;
import com.waitakaLibrary.LibraryWaitaka.Repository.ProfessorRepository;
import com.waitakaLibrary.LibraryWaitaka.Service.AluguelService;
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

//    Aluguel

    @Autowired
    @MockBean
    AluguelService aluguelService;

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

        Mockito.when(estudanteService.cadastrar(estudanteDTO, uriBuilder))
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

        Mockito.when(professorService.cadastrar(professorDTO, uriBuilder))
                .thenReturn(ResponseEntity.created(uri).body(professorDTO));
    }

    //     Funcionario


    @Test
    void testeCadastrarFuncionarioService() {
        Funcionario funcionario = UsuarioBuilder.builder().build().toFuncionario();
        FuncionarioDTO funcionarioDTO = new FuncionarioDTO(funcionario);
        Mockito.when(funcionarioService.cadastrar(funcionario)).thenReturn(funcionarioDTO);
        Mockito.when(funcionarioRepository.insert(funcionario)).thenReturn(funcionario);

    }

    @Test
    void testeDeletarFuncionarioService() throws UsuarioNaoEncontradoException {
        Funcionario funcionario = UsuarioBuilder.builder().build().toFuncionario();
        FuncionarioDTO funcionarioDTO = new FuncionarioDTO(funcionario);

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString("api/v1/funcionarios/{nome}");
        URI uri = UriComponentsBuilder.fromUriString("api/v1/funcionarios/{nome}")
                .buildAndExpand(funcionario.getNome()).toUri();
        Mockito.when(funcionarioService.deletarPorEmail(funcionario.getEmail()))
                .thenReturn(ResponseEntity.created(uri).body(funcionarioDTO));
    }

    @Test
    void testeAtualizarFuncionarioService() throws UsuarioNaoEncontradoException {
        Funcionario funcionario = UsuarioBuilder.builder().build().toFuncionario();
        FuncionarioDTO funcionarioDTO = new FuncionarioDTO(funcionario);
        funcionarioDTO.setNome("TESTEEEEE");

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString("api/v1/funcionarios/{nome}");
        URI uri = UriComponentsBuilder.fromUriString("api/v1/funcionarios/{nome}")
                .buildAndExpand(funcionario.getNome()).toUri();
        Mockito.when(funcionarioService.atualizarPorEmail(funcionario.getEmail(),funcionarioDTO))
                .thenReturn(ResponseEntity.created(uri).body(funcionarioDTO));
    }


    @Test
    void testeCadastrarFuncionarioServiceComURI() {
        Funcionario funcionario = UsuarioBuilder.builder().build().toFuncionario();
        FuncionarioDTO funcionarioDTO = new FuncionarioDTO(funcionario);
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString("api/v1/funcionarios/{nome}");
        URI uri = UriComponentsBuilder.fromUriString("api/v1/funcionarios/{nome}")
                .buildAndExpand(funcionario.getNome()).toUri();

        Mockito.when(funcionarioService.cadastrar(funcionarioDTO, uriBuilder))
                .thenReturn(ResponseEntity.created(uri).body(funcionarioDTO));
    }


    @Test
    void testeCadastrarAluguelService() throws UsuarioNaoEncontradoException, LivroNaoLocalizadoException {
        Aluguel aluguel = AluguelBuilder.builder().build().toAlguelEstudante();
        Estudante estudante = (Estudante) aluguel.getUsuario();
        AluguelDTO aluguelDTO = new AluguelDTO(aluguel);
        Funcionario funcionario = UsuarioBuilder.builder().build().toFuncionario();

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString("api/v1/funcionarios/{nome}");
        URI uri = UriComponentsBuilder.fromUriString("api/v1/funcionarios/{nome}")
                .buildAndExpand(funcionario.getNome()).toUri();

        Mockito.when(aluguelService.cadastrar(estudante.getEmail(), estudante.getEmail(), uriBuilder))
                .thenReturn(ResponseEntity.created(uri).body(aluguelDTO));
    }


}
