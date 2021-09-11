package com.waitakaLibrary.LibraryWaitaka.Service;

import com.waitakaLibrary.LibraryWaitaka.Entities.DTO.EstudanteDTO;
import com.waitakaLibrary.LibraryWaitaka.Entities.DTO.FuncionarioDTO;
import com.waitakaLibrary.LibraryWaitaka.Entities.Estudante;
import com.waitakaLibrary.LibraryWaitaka.Entities.Funcionario;
import com.waitakaLibrary.LibraryWaitaka.Repository.EstudanteRepository;
import com.waitakaLibrary.LibraryWaitaka.Repository.FuncionarioRepository;
import com.waitakaLibrary.LibraryWaitaka.mappers.EstudanteMapper;
import com.waitakaLibrary.LibraryWaitaka.mappers.FuncionarioMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    private final FuncionarioMapper funcionarioMapper = FuncionarioMapper.INSTANCE;

    public List<Funcionario> lista(){
        return funcionarioRepository.findAll();
    }

  public FuncionarioDTO cadastrar(Funcionario funcionario){
      funcionarioRepository.insert(funcionario);
        FuncionarioDTO funcionarioDTO = funcionarioMapper.toDTO(funcionario);
        return funcionarioDTO;

    }
    public ResponseEntity<FuncionarioDTO> cadastrar(Funcionario funcionario, UriComponentsBuilder uriBuilder ){
        Funcionario teste = funcionarioRepository.insert(funcionario);
        FuncionarioDTO funcionarioDTO  = funcionarioMapper.toDTO(funcionario);
        URI uri = uriBuilder.path("api/v1/funcionarios/{nome}").buildAndExpand(funcionario.getNome()).toUri();

        return ResponseEntity.created(uri).body(funcionarioDTO);

    }
}





