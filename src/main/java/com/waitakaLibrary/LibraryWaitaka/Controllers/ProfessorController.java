package com.waitakaLibrary.LibraryWaitaka.Controllers;

import com.waitakaLibrary.LibraryWaitaka.DTO.ProfessorDTO;
import com.waitakaLibrary.LibraryWaitaka.Entities.Professor;
import com.waitakaLibrary.LibraryWaitaka.Exceptions.UsuarioNaoEncontradoException;
import com.waitakaLibrary.LibraryWaitaka.Service.ProfessorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping("api/v1/professores")
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Api(value = "Professor",  tags = { "Professor" })
public class ProfessorController {

    private ProfessorService professorService;

    @GetMapping
    @ApiOperation(value = "Retonar todos os Professores",
            notes = "Este endpoint retorna todos os professores")
    public List<ProfessorDTO> listar(){
        return professorService.listar();
    }

    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Cadastrar o Professor",
            notes = "Este endpoint recebe um Professor com os parâmetros:  Nome,   Telefone, Matricula, CEP,Email")
    public ResponseEntity<ProfessorDTO> cadastrar(@RequestBody @Valid ProfessorDTO professorDTO, UriComponentsBuilder uriBuilder){
        return professorService.cadastrar(professorDTO, uriBuilder);
    }
    @PutMapping("{email}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ApiOperation(value = "Atualizar o Professor",
            notes = "Este endpoint recebe um email  e atualiza o professor correspondente a esse email, "+
                    "usando o(s) parâmetro(s) enviado(s).")
    public ResponseEntity<ProfessorDTO> atualizarPorEmail(@PathVariable @Valid String email, @RequestBody ProfessorDTO professorDTO) throws UsuarioNaoEncontradoException {
        return professorService.atualizarPorEmail(email, professorDTO);
    }

    @DeleteMapping("{email}")
    @Transactional
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Deletar um Professor",
            notes = "Este endpoint recebe um e-mail e deleta o Professor referente a esse e-mail.")
    public ResponseEntity<ProfessorDTO> deletar(@PathVariable String email ) throws UsuarioNaoEncontradoException {
        return professorService.deletarPorEmail(email);
    }

}
