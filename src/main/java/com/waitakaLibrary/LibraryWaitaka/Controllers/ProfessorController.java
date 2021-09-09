package com.waitakaLibrary.LibraryWaitaka.Controllers;

import com.waitakaLibrary.LibraryWaitaka.Entities.DTO.EstudanteDTO;
import com.waitakaLibrary.LibraryWaitaka.Entities.DTO.ProfessorDTO;
import com.waitakaLibrary.LibraryWaitaka.Entities.Estudante;
import com.waitakaLibrary.LibraryWaitaka.Entities.Professor;
import com.waitakaLibrary.LibraryWaitaka.Service.EstudanteService;
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
    public List<Professor> listar(){
        return professorService.lista();
    }

    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ProfessorDTO> cadastrar(@RequestBody @Valid Professor professor, UriComponentsBuilder uriBuilder){
        return professorService.cadastrar(professor, uriBuilder);
    }


}
