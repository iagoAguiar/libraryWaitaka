package com.waitakaLibrary.LibraryWaitaka.Controllers;

import com.waitakaLibrary.LibraryWaitaka.DTO.ProfessorDTO;
import com.waitakaLibrary.LibraryWaitaka.Entities.Professor;
import com.waitakaLibrary.LibraryWaitaka.Exceptions.UsuarioNaoEncontradoException;
import com.waitakaLibrary.LibraryWaitaka.Service.ProfessorService;
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
public class ProfessorController {

    private ProfessorService professorService;

    @GetMapping
    public List<ProfessorDTO> listar(){
        return professorService.listar();
    }

    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ProfessorDTO> cadastrar(@RequestBody @Valid ProfessorDTO professorDTO, UriComponentsBuilder uriBuilder){
        return professorService.cadastrar(professorDTO, uriBuilder);
    }
    @PutMapping("{email}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<ProfessorDTO> atualizarPorEmail(@PathVariable @Valid String email, @RequestBody ProfessorDTO professorDTO) throws UsuarioNaoEncontradoException {
        return professorService.atualizarPorEmail(email, professorDTO);
    }

    @DeleteMapping("{email}")
    @Transactional
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ProfessorDTO> deletar(@PathVariable String email ) throws UsuarioNaoEncontradoException {
        return professorService.deletarPorEmail(email);
    }

}
