package com.waitakaLibrary.LibraryWaitaka.Service;

import com.waitakaLibrary.LibraryWaitaka.DTO.ProfessorDTO;
import com.waitakaLibrary.LibraryWaitaka.Entities.Professor;
import com.waitakaLibrary.LibraryWaitaka.Exceptions.UsuarioNaoEncontradoException;
import com.waitakaLibrary.LibraryWaitaka.Repository.ProfessorRepository;
import com.waitakaLibrary.LibraryWaitaka.mappers.ProfessorMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    private final ProfessorMapper professorMapper = ProfessorMapper.INSTANCE;

    public List<ProfessorDTO> listar(){
        List<Professor> professores = professorRepository.findAll();
        return professores.stream().map( model -> new ProfessorDTO(model)).collect(Collectors.toList());
    }

  public ProfessorDTO cadastrar(Professor professor){
      professorRepository.insert(professor);
        ProfessorDTO professorDTO = professorMapper.toDTO(professor);
        return professorDTO;

    }

    public ResponseEntity<ProfessorDTO> cadastrar(ProfessorDTO professorDTO, UriComponentsBuilder uriBuilder ){
        Professor professor  = professorDTO.toProfessor();
        professorRepository.insert(professor);
        URI uri = uriBuilder.path("api/v1/professores/{nome}").buildAndExpand(professorDTO.getNome()).toUri();

        return ResponseEntity.created(uri).body(professorDTO);

    }

    public ResponseEntity<ProfessorDTO> atualizarPorEmail (String email, ProfessorDTO professorDTO) throws UsuarioNaoEncontradoException {

        Professor professorParaSalvar = verificaSeExiste(email);

        if(professorDTO.getNome() != null){
            professorParaSalvar.setNome(professorDTO.getNome());
        }
        if(professorDTO.getMatricula() != null) {
            professorParaSalvar.setMatricula(professorDTO.getMatricula());
        }
        if(professorDTO.getCEP() != null) {
            professorParaSalvar.setCEP(professorDTO.getCEP());
        }
        if(professorDTO.getTelefone() != null) {
            professorParaSalvar.setTelefone(professorDTO.getTelefone());
        }

        Professor professor = professorRepository.save(professorParaSalvar);
        ProfessorDTO professorSalvoDTO = new ProfessorDTO(professor);

        return ResponseEntity.ok(professorSalvoDTO);

    }


    public ResponseEntity<ProfessorDTO> deletarPorEmail (String email) throws UsuarioNaoEncontradoException {
        Professor professorParadeletar = verificaSeExiste(email);
        professorRepository.deleteById(professorParadeletar.getId());
        ProfessorDTO professorDeletadoDTO = new ProfessorDTO(professorParadeletar);
        return ResponseEntity.ok(professorDeletadoDTO);
    }

    private Professor verificaSeExiste(String email) throws UsuarioNaoEncontradoException {
        Optional<Professor> professor = professorRepository.findByEmail(email);
        if (professor.isPresent()) {
            return professor.get();
        } else {
            throw new UsuarioNaoEncontradoException(email);
        }


    }
}





