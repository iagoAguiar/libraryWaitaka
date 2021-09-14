package com.waitakaLibrary.LibraryWaitaka.Service;

import com.waitakaLibrary.LibraryWaitaka.Entities.*;
import com.waitakaLibrary.LibraryWaitaka.Entities.DTO.AluguelDTO;
import com.waitakaLibrary.LibraryWaitaka.Entities.Form.AluguelForm;
import com.waitakaLibrary.LibraryWaitaka.Exceptions.UsuarioNaoEncontradoHandler;
import com.waitakaLibrary.LibraryWaitaka.Repository.AluguelRepository;
import com.waitakaLibrary.LibraryWaitaka.Repository.EstudanteRepository;
import com.waitakaLibrary.LibraryWaitaka.Repository.FuncionarioRepository;
import com.waitakaLibrary.LibraryWaitaka.Repository.ProfessorRepository;
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


    public List<Aluguel> lista(){
        return aluguelRepository.findAll();
    }

  public AluguelDTO cadastrar(Aluguel aluguel){
        aluguelRepository.insert(aluguel);
        AluguelDTO aluguelDTO = new AluguelDTO(aluguel);
        return aluguelDTO;

    }

    public ResponseEntity<AluguelDTO> cadastrar(AluguelForm aluguelForm, UriComponentsBuilder uriBuilder ) throws UsuarioNaoEncontradoHandler {

        Usuario usuario = getUsuario(aluguelForm);

        Aluguel aluguel = aluguelForm.toAluguel(usuario);

        aluguelRepository.insert(aluguel);
            AluguelDTO aluguelDTO = new AluguelDTO(aluguel);
            URI uri = uriBuilder.path("api/v1/alugueis/{titulo}").buildAndExpand(aluguel.getTitulo()).toUri();

            return ResponseEntity.created(uri).body(aluguelDTO);


    }

    private Usuario getUsuario(AluguelForm aluguelForm) throws UsuarioNaoEncontradoHandler {

        Optional<Funcionario> funcionario = funcionarioRepository.findByEmail(aluguelForm.getEmailusuario());
        if(funcionario.isPresent()) {
            Funcionario usuario = funcionario.get();
            return usuario;

        }

        Optional<Estudante> estudante = estudanteRepository.findByEmail(aluguelForm.getEmailusuario());
        if(estudante.isPresent()) {
            Estudante usuario = estudante.get();
            return usuario;
        }


        Optional<Professor> professor = professorRepository.findByEmail(aluguelForm.getEmailusuario());
        if(professor.isPresent()) {
          Professor usuario = professor.get();
          return usuario;
        }
        else{
            throw new UsuarioNaoEncontradoHandler(aluguelForm.getEmailusuario());
        }
    }



}





