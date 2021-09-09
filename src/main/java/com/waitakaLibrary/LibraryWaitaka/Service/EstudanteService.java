package com.waitakaLibrary.LibraryWaitaka.Service;

import com.waitakaLibrary.LibraryWaitaka.Entities.DTO.EstudanteDTO;
import com.waitakaLibrary.LibraryWaitaka.Entities.Estudante;
import com.waitakaLibrary.LibraryWaitaka.Repository.EstudanteRepository;
import com.waitakaLibrary.LibraryWaitaka.mappers.EstudanteMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EstudanteService {

        private final EstudanteRepository estudanteRepository;
    @Autowired
    EstudanteMapper estudanteMapper;

    public List<Estudante> lista(){
        return estudanteRepository.findAll();
    }

  public EstudanteDTO cadastrar(Estudante estudante){
        EstudanteDTO estudanteDTO = estudanteMapper.toDTO(estudanteRepository.insert(estudante));
        return estudanteDTO;

    }
    public ResponseEntity<EstudanteDTO> cadastrar(Estudante estudante, UriComponentsBuilder uriBuilder ){

        EstudanteDTO estudanteDTO  = estudanteMapper.toDTO(estudanteRepository.insert(estudante));
        URI uri = uriBuilder.path("api/v1/estudantes/{nome}").buildAndExpand(estudanteDTO.getNome()).toUri();

        return ResponseEntity.created(uri).body(estudanteDTO);

    }
}





