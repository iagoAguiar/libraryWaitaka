package com.waitakaLibrary.LibraryWaitaka.Controllers;

import com.waitakaLibrary.LibraryWaitaka.Entities.DTO.EstudanteDTO;
import com.waitakaLibrary.LibraryWaitaka.Entities.DTO.FuncionarioDTO;
import com.waitakaLibrary.LibraryWaitaka.Entities.Estudante;
import com.waitakaLibrary.LibraryWaitaka.Service.EstudanteService;
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
    public List<Estudante> listar(){
        return estudanteService.lista();
    }

    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<EstudanteDTO> cadastrar(@RequestBody @Valid Estudante estudante, UriComponentsBuilder uriBuilder){
        return estudanteService.cadastrar(estudante, uriBuilder);
    }

    @PutMapping("{email}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<EstudanteDTO> atualizarPorEmail(@PathVariable @Valid String email, @RequestBody @Valid EstudanteDTO estudanteDTO){

        return estudanteService.atualizarPorEmail(email, estudanteDTO);
    }

    @DeleteMapping("{email}")
    @Transactional
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<EstudanteDTO> deletar(@PathVariable String email ){
        return estudanteService.deletarPorEmail(email);
    }



}
