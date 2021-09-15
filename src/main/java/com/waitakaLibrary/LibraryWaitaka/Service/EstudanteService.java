package com.waitakaLibrary.LibraryWaitaka.Service;

import com.waitakaLibrary.LibraryWaitaka.DTO.EstudanteDTO;
import com.waitakaLibrary.LibraryWaitaka.Entities.Estudante;
import com.waitakaLibrary.LibraryWaitaka.Exceptions.UsuarioNaoEncontradoException;
import com.waitakaLibrary.LibraryWaitaka.Repository.EstudanteRepository;
import com.waitakaLibrary.LibraryWaitaka.mappers.EstudanteMapper;
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
public class EstudanteService {

    private final EstudanteRepository estudanteRepository;

    private final EstudanteMapper estudanteMapper = EstudanteMapper.INSTANCE;

    public List<EstudanteDTO> listar(){
        List<Estudante> estudantes = estudanteRepository.findAll();
        return estudantes.stream().map(model -> new EstudanteDTO(model)).collect(Collectors.toList());
    }

  public EstudanteDTO cadastrar(Estudante estudante){
        estudanteRepository.insert(estudante);
        EstudanteDTO estudanteDTO = estudanteMapper.toDTO(estudante);
        return estudanteDTO;

    }
    public ResponseEntity<EstudanteDTO> cadastrar(EstudanteDTO estudanteDTO, UriComponentsBuilder uriBuilder ){
        Estudante estudante = estudanteDTO.toEstudante();
        estudanteRepository.insert(estudante);
        URI uri = uriBuilder.path("api/v1/estudantes/{nome}").buildAndExpand(estudanteDTO.getNome()).toUri();

        return ResponseEntity.created(uri).body(estudanteDTO);

    }

    public ResponseEntity<EstudanteDTO> atualizarPorEmail (String email, EstudanteDTO estudanteDTO) throws UsuarioNaoEncontradoException {

        Estudante estudanteParaSalvar = verificaSeExiste(email);

        if(estudanteDTO.getNome() != null){
            estudanteParaSalvar.setNome(estudanteDTO.getNome());
        }
        if(estudanteDTO.getMatricula() != null) {
            estudanteParaSalvar.setMatricula(estudanteDTO.getMatricula());
        }
        if(estudanteDTO.getCEP() != null) {
            estudanteParaSalvar.setCEP(estudanteDTO.getCEP());
        }
        if(estudanteDTO.getTelefone() != null) {
            estudanteParaSalvar.setTelefone(estudanteDTO.getTelefone());
        }


        Estudante estudanteSalvo = estudanteRepository.save(estudanteParaSalvar);
        EstudanteDTO EstudanteSalvoDTO = new EstudanteDTO(estudanteSalvo);
        return ResponseEntity.ok(EstudanteSalvoDTO);


    }

    public ResponseEntity<EstudanteDTO> deletarPorEmail (String email) throws UsuarioNaoEncontradoException {
        Estudante estudanteParaDeletar = verificaSeExiste(email);
        estudanteRepository.deleteById(estudanteParaDeletar.getId());
        EstudanteDTO estudanteDeletadoDTO = new EstudanteDTO(estudanteParaDeletar);
        return ResponseEntity.ok(estudanteDeletadoDTO);
    }




    private Estudante verificaSeExiste(String email) throws UsuarioNaoEncontradoException {
        Optional<Estudante> estudante =  estudanteRepository.findByEmail(email);
        if (estudante.isPresent()){
          return estudante.get();
        } else {
            throw new UsuarioNaoEncontradoException(email);
        }

    }


}





