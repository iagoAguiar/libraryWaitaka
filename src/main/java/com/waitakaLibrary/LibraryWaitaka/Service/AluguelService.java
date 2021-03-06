package com.waitakaLibrary.LibraryWaitaka.Service;

import com.waitakaLibrary.LibraryWaitaka.Entities.*;
import com.waitakaLibrary.LibraryWaitaka.DTO.AluguelDTO;
import com.waitakaLibrary.LibraryWaitaka.Exceptions.LivroNaoLocalizadoException;
import com.waitakaLibrary.LibraryWaitaka.Exceptions.UsuarioNaoEncontradoException;
import com.waitakaLibrary.LibraryWaitaka.Repository.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AluguelService {

    private final AluguelRepository aluguelRepository;

    private final ProfessorRepository professorRepository;

    private final EstudanteRepository estudanteRepository;

    private final FuncionarioRepository funcionarioRepository;

    private final LivroRepository livroRepository;

//    GET
    public List<AluguelDTO> listar(){
        List<Aluguel> aluguel = aluguelRepository.findAll();
        return aluguel.stream().map(model -> new AluguelDTO(model)).collect(Collectors.toList());
    }

  public AluguelDTO cadastrar(Aluguel aluguel){
        aluguelRepository.insert(aluguel);
        AluguelDTO aluguelDTO = new AluguelDTO(aluguel);
        return aluguelDTO;

    }
//   POST
    public ResponseEntity<AluguelDTO> cadastrar(String titulo, String email, UriComponentsBuilder uriBuilder )
            throws LivroNaoLocalizadoException, UsuarioNaoEncontradoException {

       Usuario usuario = getUsuario(email);

        verificarSeExisteLivro(titulo);
        Livro livro = livroRepository.findByTitulo(titulo).get();

        Aluguel aluguel = new Aluguel(livro, usuario);

        aluguelRepository.insert(aluguel);
            AluguelDTO aluguelDTO = new AluguelDTO(aluguel);
            URI uri = uriBuilder.path("api/v1/alugueis/{titulo}").buildAndExpand(aluguel.getLivro().getTitulo()).toUri();

            return ResponseEntity.created(uri).body(aluguelDTO);
    }

//      DELET

    public ResponseEntity<AluguelDTO> deletarPorTituloLivro(String titulo) throws LivroNaoLocalizadoException {
        Aluguel aluguelParaDeletar = verificarSeExisteAluguel(titulo);

        aluguelRepository.deleteById(aluguelParaDeletar.getId());

        AluguelDTO aluguelDeletadoDTO = new AluguelDTO(aluguelParaDeletar);
        return ResponseEntity.ok(aluguelDeletadoDTO);
    }


//    UTILS

    private Usuario getUsuario(String email) throws UsuarioNaoEncontradoException {

        Optional<Funcionario> funcionario = funcionarioRepository.findByEmail(email);
        if(funcionario.isPresent()) {
            Funcionario usuario = funcionario.get();
            return usuario;
        }

        Optional<Estudante> estudante = estudanteRepository.findByEmail(email);
        if(estudante.isPresent()) {
            Estudante usuario = estudante.get();
            return usuario;
        }

        Optional<Professor> professor = professorRepository.findByEmail(email);
        if(professor.isPresent()) {
          Professor usuario = professor.get();
          return usuario;
        }
        else{
            throw new UsuarioNaoEncontradoException(email);
        }
    }

    private Livro verificarSeExisteLivro(String titulo) throws LivroNaoLocalizadoException {
       Optional<Livro> livro = livroRepository.findByTitulo(titulo);
        if(livro.isEmpty()){
            throw new LivroNaoLocalizadoException(titulo);
        }
        return livro.get();
    }

    private Aluguel verificarSeExisteAluguel(String titulo) throws LivroNaoLocalizadoException {
       Optional<Aluguel> aluguel = aluguelRepository.findByLivroTitulo(titulo);
        if(aluguel.isEmpty()){
            throw new LivroNaoLocalizadoException(titulo);
        }
        return aluguel.get();
    }



}





