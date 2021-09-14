package com.waitakaLibrary.LibraryWaitaka.Service;

import com.waitakaLibrary.LibraryWaitaka.Entities.DTO.ProfessorDTO;
import com.waitakaLibrary.LibraryWaitaka.Entities.Professor;
import com.waitakaLibrary.LibraryWaitaka.Exceptions.UsuarioNaoEncontradoHandler;
import com.waitakaLibrary.LibraryWaitaka.Repository.ProfessorRepository;
import com.waitakaLibrary.LibraryWaitaka.mappers.ProfessorMapper;
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
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    private final ProfessorMapper professorMapper = ProfessorMapper.INSTANCE;

    public List<Professor> lista(){
        return professorRepository.findAll();
    }

  public ProfessorDTO cadastrar(Professor professor){
      professorRepository.insert(professor);
        ProfessorDTO professorDTO = professorMapper.toDTO(professor);
        return professorDTO;

    }
    public ResponseEntity<ProfessorDTO> cadastrar(Professor professor, UriComponentsBuilder uriBuilder ){
        professorRepository.insert(professor);
        ProfessorDTO professorDTO  = professorMapper.toDTO(professor);
        URI uri = uriBuilder.path("api/v1/professores/{nome}").buildAndExpand(professor.getNome()).toUri();

        return ResponseEntity.created(uri).body(professorDTO);

    }

    public ResponseEntity<ProfessorDTO> atualizarPorEmail (String email, ProfessorDTO professorDTO) throws UsuarioNaoEncontradoHandler {

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


    public ResponseEntity<ProfessorDTO> deletarPorEmail (String email) throws UsuarioNaoEncontradoHandler {
        Professor professorParadeletar = verificaSeExiste(email);
        professorRepository.deleteById(professorParadeletar.getId());
        ProfessorDTO professorDeletadoDTO = new ProfessorDTO(professorParadeletar);
        return ResponseEntity.ok(professorDeletadoDTO);
    }

    private Professor verificaSeExiste(String email) throws UsuarioNaoEncontradoHandler {
        Optional<Professor> professor = professorRepository.findByEmail(email);
        if (professor.isPresent()) {
            return professor.get();
        } else {
            throw new UsuarioNaoEncontradoHandler(email);
        }


    }
}





