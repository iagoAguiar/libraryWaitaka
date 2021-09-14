package com.waitakaLibrary.LibraryWaitaka.Controllers;

import com.waitakaLibrary.LibraryWaitaka.Entities.DTO.FuncionarioDTO;
import com.waitakaLibrary.LibraryWaitaka.Entities.DTO.ProfessorDTO;
import com.waitakaLibrary.LibraryWaitaka.Entities.Funcionario;
import com.waitakaLibrary.LibraryWaitaka.Service.FuncionarioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@Controller
@RestController
@RequestMapping("api/v1/funcionarios")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class FuncionarioController {

    private FuncionarioService funcionarioService;

    @GetMapping
    public List<Funcionario> listar(){
        return funcionarioService.lista();
    }

    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<FuncionarioDTO> cadastrar(@RequestBody @Valid Funcionario funcionario, UriComponentsBuilder uriBuilder){
        return funcionarioService.cadastrar(funcionario, uriBuilder);
    }


    @PutMapping("{email}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<FuncionarioDTO> atualizarPorEmail(@PathVariable @Valid String email, @RequestBody FuncionarioDTO funcionarioDTO){
        return funcionarioService.atualizarPorEmail(email, funcionarioDTO);
    }
    @DeleteMapping("{email}")
    @Transactional
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<FuncionarioDTO> deletar(@PathVariable String email ){
        return funcionarioService.deletarPorEmail(email);
    }

}
