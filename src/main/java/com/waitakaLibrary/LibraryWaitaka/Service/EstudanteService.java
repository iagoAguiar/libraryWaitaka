package com.waitakaLibrary.LibraryWaitaka.Service;

import com.waitakaLibrary.LibraryWaitaka.Entities.Estudante;
import com.waitakaLibrary.LibraryWaitaka.Repository.EstudanteRepository;
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



    public List<Estudante> lista(){
        return estudanteRepository.findAll();
    }

  public Estudante cadastrar(Estudante estudante){
        Estudante estudantesalvo = estudanteRepository.insert(estudante);
        return estudantesalvo;

    }
    public ResponseEntity<Estudante> cadastrar(Estudante estudante, UriComponentsBuilder uriBuilder ){
        Estudante estudantesalvo = estudanteRepository.insert(estudante);
        URI uri = uriBuilder.path("api/v1/estudantes/{nome}").buildAndExpand(estudantesalvo.getNome()).toUri();

        return ResponseEntity.created(uri).body(estudantesalvo);

    }
}





