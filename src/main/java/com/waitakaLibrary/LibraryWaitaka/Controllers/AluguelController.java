package com.waitakaLibrary.LibraryWaitaka.Controllers;

import com.waitakaLibrary.LibraryWaitaka.Entities.Aluguel;
import com.waitakaLibrary.LibraryWaitaka.Entities.DTO.AluguelDTO;
import com.waitakaLibrary.LibraryWaitaka.Entities.Form.AluguelForm;
import com.waitakaLibrary.LibraryWaitaka.Exceptions.LivroNaoLocalizadoHandler;
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
    public List<Aluguel> listar(){return aluguelService.lista();}

    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<AluguelDTO> cadastrar(@RequestBody @Valid AluguelForm aluguelForm, UriComponentsBuilder uriBuilder) throws UsuarioNaoEncontradoHandler, LivroNaoLocalizadoHandler {
         return aluguelService.cadastrar(aluguelForm.getTitulo(), aluguelForm.getEmail(), uriBuilder);
    }

//    @PutMapping("{titulo}")
//    @ResponseStatus(HttpStatus.ACCEPTED)
//    public ResponseEntity<AluguelDTO> atualizarPorNome(@PathVariable @Valid String titulo, @RequestBody AluguelDTO aluguelDTO)  {
//        return aluguelService.atualizarPorTitulo(titulo, aluguelDTO);
//    }

    @DeleteMapping("{titulo}")
    @Transactional
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<AluguelDTO> deletaPorTituloLivro(@PathVariable @Valid String titulo) throws LivroNaoLocalizadoHandler {
        return aluguelService.deletaPorTituloLivro(titulo);
    }


}
