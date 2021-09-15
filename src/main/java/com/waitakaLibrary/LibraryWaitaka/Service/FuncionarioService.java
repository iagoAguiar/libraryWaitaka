package com.waitakaLibrary.LibraryWaitaka.Service;

import com.waitakaLibrary.LibraryWaitaka.DTO.FuncionarioDTO;
import com.waitakaLibrary.LibraryWaitaka.Entities.Funcionario;
import com.waitakaLibrary.LibraryWaitaka.Exceptions.UsuarioNaoEncontradoException;
import com.waitakaLibrary.LibraryWaitaka.Repository.FuncionarioRepository;
import com.waitakaLibrary.LibraryWaitaka.mappers.FuncionarioMapper;
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
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    private final FuncionarioMapper funcionarioMapper = FuncionarioMapper.INSTANCE;

    public List<FuncionarioDTO> listar() {

        List<Funcionario> funcionarios = funcionarioRepository.findAll();
        return funcionarios.stream().map(model -> new FuncionarioDTO(model)).collect(Collectors.toList());
    }

    public FuncionarioDTO cadastrar(Funcionario funcionario) {
        funcionarioRepository.insert(funcionario);
        FuncionarioDTO funcionarioDTO = funcionarioMapper.toDTO(funcionario);
        return funcionarioDTO;

    }

    public ResponseEntity<FuncionarioDTO> cadastrar(FuncionarioDTO funcionarioDTO, UriComponentsBuilder uriBuilder) {
        Funcionario funcionario = funcionarioDTO.toFuncionario();
        Funcionario funcionarioSalvo= funcionarioRepository.insert(funcionario);

        URI uri = uriBuilder.path("api/v1/funcionarios/{nome}").buildAndExpand(funcionario.getNome()).toUri();

        return ResponseEntity.created(uri).body(new FuncionarioDTO(funcionarioSalvo));

    }

    public ResponseEntity<FuncionarioDTO> atualizarPorEmail (String email, FuncionarioDTO funcionarioDTO)
            throws UsuarioNaoEncontradoException {

        Funcionario funcionarioParaSalvar = verificaSeExiste(email);

        if(funcionarioDTO.getNome() != null){
            funcionarioParaSalvar.setNome(funcionarioDTO.getNome());
        }
        if(funcionarioDTO.getMatricula() != null) {
            funcionarioParaSalvar.setMatricula(funcionarioDTO.getMatricula());
        }
        if(funcionarioDTO.getCEP() != null) {
            funcionarioParaSalvar.setCEP(funcionarioDTO.getCEP());
        }
        if(funcionarioDTO.getTelefone() != null) {
            funcionarioParaSalvar.setTelefone(funcionarioDTO.getTelefone());
        }

        Funcionario funcionario = funcionarioRepository.save(funcionarioParaSalvar);
        FuncionarioDTO funcionarioSalvoDTO = new FuncionarioDTO(funcionario);

        return ResponseEntity.ok(funcionarioSalvoDTO);

    }

    public ResponseEntity<FuncionarioDTO> deletarPorEmail (String email) throws UsuarioNaoEncontradoException {
        Funcionario funcionarioParaDeletar = verificaSeExiste(email);
        funcionarioRepository.deleteById(funcionarioParaDeletar.getId());
        FuncionarioDTO funcionarioDeletadoDTO = new FuncionarioDTO(funcionarioParaDeletar);
        return ResponseEntity.ok(funcionarioDeletadoDTO);
    }


    private Funcionario verificaSeExiste(String email) throws UsuarioNaoEncontradoException {
        Optional<Funcionario> funcionario = funcionarioRepository.findByEmail(email);
        if (funcionario.isPresent()) {
            return funcionario.get();
        } else {
            throw new UsuarioNaoEncontradoException(email);
        }


    }
}





