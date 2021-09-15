package com.waitakaLibrary.LibraryWaitaka.Service;

import com.waitakaLibrary.LibraryWaitaka.Entities.*;
import com.waitakaLibrary.LibraryWaitaka.Entities.DTO.AluguelDTO;
import com.waitakaLibrary.LibraryWaitaka.Entities.DTO.LivroDTO;
import com.waitakaLibrary.LibraryWaitaka.Entities.Form.AluguelForm;
import com.waitakaLibrary.LibraryWaitaka.Entities.Form.LivroForm;
import com.waitakaLibrary.LibraryWaitaka.Exceptions.LivroNaoLocalizadoHandler;
import com.waitakaLibrary.LibraryWaitaka.Exceptions.UsuarioNaoEncontradoHandler;
import com.waitakaLibrary.LibraryWaitaka.Repository.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AluguelService {

    private final AluguelRepository aluguelRepository;

    private final ProfessorRepository professorRepository;

    private final EstudanteRepository estudanteRepository;

    private final FuncionarioRepository funcionarioRepository;

    private final LivroRepository livroRepository;


    public List<Aluguel> lista(){
        return aluguelRepository.findAll();
    }

  public AluguelDTO cadastrar(Aluguel aluguel){
        aluguelRepository.insert(aluguel);
        AluguelDTO aluguelDTO = new AluguelDTO(aluguel);
        return aluguelDTO;

    }

    public ResponseEntity<AluguelDTO> cadastrar(String titulo, String email, UriComponentsBuilder uriBuilder )
            throws LivroNaoLocalizadoHandler, UsuarioNaoEncontradoHandler {

       Usuario usuario = getUsuario(email);

        verificarSeExisteLivro(titulo);
        Livros livro = livroRepository.findByTitulo(titulo).get();

        System.out.println(livro.getId());
        Aluguel aluguel = new Aluguel(livro, usuario);

        aluguelRepository.insert(aluguel);
            AluguelDTO aluguelDTO = new AluguelDTO(aluguel);
            URI uri = uriBuilder.path("api/v1/alugueis/{titulo}").buildAndExpand(aluguel.getLivro().getTitulo()).toUri();

            return ResponseEntity.created(uri).body(aluguelDTO);
    }

    private Usuario getUsuario(String email) throws UsuarioNaoEncontradoHandler {

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
            throw new UsuarioNaoEncontradoHandler(email);
        }
    }

    public ResponseEntity<AluguelDTO> deletaPorTituloLivro(String titulo) throws LivroNaoLocalizadoHandler {
        Aluguel aluguelParaDeletar = verificarSeExisteAluguel(titulo);

        aluguelRepository.deleteById(aluguelParaDeletar.getId());

        AluguelDTO aluguelDeletadoDTO = new AluguelDTO(aluguelParaDeletar);
        return ResponseEntity.ok(aluguelDeletadoDTO);

    }

    private Livros verificarSeExisteLivro(String titulo) throws LivroNaoLocalizadoHandler {
       Optional<Livros> livro = livroRepository.findByTitulo(titulo);
        if(livro.isEmpty()){
            throw new LivroNaoLocalizadoHandler(titulo);
        }
        return livro.get();
    }

    private Aluguel verificarSeExisteAluguel(String titulo) throws LivroNaoLocalizadoHandler {
       Optional<Aluguel> aluguel = aluguelRepository.findByLivroTitulo(titulo);
        if(aluguel.isEmpty()){
            throw new LivroNaoLocalizadoHandler(titulo);
        }
        return aluguel.get();
    }



}





