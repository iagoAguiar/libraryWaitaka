package com.waitakaLibrary.LibraryWaitaka.Controllers;

import com.waitakaLibrary.LibraryWaitaka.Entities.Aluguel;
import com.waitakaLibrary.LibraryWaitaka.Entities.DTO.AluguelDTO;
import com.waitakaLibrary.LibraryWaitaka.Entities.Form.AluguelForm;
import com.waitakaLibrary.LibraryWaitaka.Exceptions.UsuarioNaoEncontradoHandler;
import com.waitakaLibrary.LibraryWaitaka.Service.AluguelService;
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
@RequestMapping("api/v1/alugueis")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AluguelController {

    private AluguelService aluguelService;

    @GetMapping
    public List<Aluguel> listar(){
        return aluguelService.lista();
    }

    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AluguelDTO> cadastrar(@RequestBody @Valid AluguelForm aluguel, UriComponentsBuilder uriBuilder) throws UsuarioNaoEncontradoHandler {
        return aluguelService.cadastrar(aluguel, uriBuilder);
    }




}
