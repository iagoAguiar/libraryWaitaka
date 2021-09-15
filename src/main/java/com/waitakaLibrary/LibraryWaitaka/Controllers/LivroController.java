package com.waitakaLibrary.LibraryWaitaka.Controllers;

import com.waitakaLibrary.LibraryWaitaka.Entities.DTO.LivroDTO;
import com.waitakaLibrary.LibraryWaitaka.Entities.Form.LivroForm;

import com.waitakaLibrary.LibraryWaitaka.Entities.Livros;
import com.waitakaLibrary.LibraryWaitaka.Exceptions.LivroNaoLocalizadoHandler;
import com.waitakaLibrary.LibraryWaitaka.Exceptions.UsuarioNaoEncontradoHandler;
import com.waitakaLibrary.LibraryWaitaka.Service.LivroService;
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
@RequestMapping("api/v1/livros")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class LivroController {

    private LivroService livroService;

    @GetMapping
    public List<Livros> listar(){
        return livroService.lista();
    }

    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<LivroDTO> cadastrar(@RequestBody @Valid LivroForm livroForm, UriComponentsBuilder uriBuilder) throws UsuarioNaoEncontradoHandler {
        return livroService.cadastrar(livroForm, uriBuilder);
    }
    @PutMapping("{titulo}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<LivroDTO> atualizarPorNome(@PathVariable @Valid String titulo, @RequestBody LivroDTO livroDTO) throws LivroNaoLocalizadoHandler {
        return livroService.atualizarPorTitulo(titulo, livroDTO);
    }

    @DeleteMapping("{titulo}")
    @Transactional
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<LivroDTO> deletaPorNome(@PathVariable @Valid String titulo) throws LivroNaoLocalizadoHandler {
        return livroService.deletaPorTitulo(titulo);
    }
}
