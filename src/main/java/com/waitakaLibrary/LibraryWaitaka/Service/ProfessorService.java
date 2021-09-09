package com.waitakaLibrary.LibraryWaitaka.Service;

import com.waitakaLibrary.LibraryWaitaka.Entities.DTO.EstudanteDTO;
import com.waitakaLibrary.LibraryWaitaka.Entities.DTO.ProfessorDTO;
import com.waitakaLibrary.LibraryWaitaka.Entities.Estudante;
import com.waitakaLibrary.LibraryWaitaka.Entities.Professor;
import com.waitakaLibrary.LibraryWaitaka.Repository.EstudanteRepository;
import com.waitakaLibrary.LibraryWaitaka.Repository.ProfessorRepository;
import com.waitakaLibrary.LibraryWaitaka.mappers.EstudanteMapper;
import com.waitakaLibrary.LibraryWaitaka.mappers.ProfessorMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

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
}





