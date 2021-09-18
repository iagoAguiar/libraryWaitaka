package com.waitakaLibrary.LibraryWaitaka.Controllers;

import com.waitakaLibrary.LibraryWaitaka.DTO.EstudanteDTO;
import com.waitakaLibrary.LibraryWaitaka.Entities.Estudante;
import com.waitakaLibrary.LibraryWaitaka.Exceptions.UsuarioNaoEncontradoException;
import com.waitakaLibrary.LibraryWaitaka.Service.EstudanteService;
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
@RequestMapping("api/v1/estudantes")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EstudanteController {

    private EstudanteService estudanteService;

    @GetMapping
    @ApiOperation(value = "Retonar todos os Estudantes",
            notes = "Este endpoint retorna todos os estudantes")
    public List<EstudanteDTO> listar(){
        return estudanteService.listar();
    }

    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Cadastrar Estudantes",
            notes = "Este endpoint cadastra estudantes, recebendo os parâmetros: Nome, telefone, Matricula e CEP")
    public ResponseEntity<EstudanteDTO> cadastrar(@RequestBody @Valid EstudanteDTO estudanteDTO, UriComponentsBuilder uriBuilder){
        return estudanteService.cadastrar(estudanteDTO, uriBuilder);
    }

    @PutMapping("{email}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ApiOperation(value = "Atualizar Estudantes",
            notes = "Este endpoint recebe um email  e atualiza o estudante correspondente a esse email, "+
                    "usando o(s) parâmetro(s) enviado(s).")
    public ResponseEntity<EstudanteDTO> atualizarPorEmail(@PathVariable @Valid String email, @RequestBody @Valid EstudanteDTO estudanteDTO) throws UsuarioNaoEncontradoException {

        return estudanteService.atualizarPorEmail(email, estudanteDTO);
    }

    @DeleteMapping("{email}")
    @Transactional
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Deletar o Estudante",
            notes = "Este endpoint recebe um email e deleta o Estudante correspondente a esse email.")
    public ResponseEntity<EstudanteDTO> deletar(@PathVariable String email ) throws UsuarioNaoEncontradoException {
        return estudanteService.deletarPorEmail(email);
    }



}
