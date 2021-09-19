package com.waitakaLibrary.LibraryWaitaka.Controllers;

import com.waitakaLibrary.LibraryWaitaka.DTO.LivroDTO;
import com.waitakaLibrary.LibraryWaitaka.Entities.Form.LivroForm;

import com.waitakaLibrary.LibraryWaitaka.Entities.Livro;
import com.waitakaLibrary.LibraryWaitaka.Exceptions.LivroNaoLocalizadoException;
import com.waitakaLibrary.LibraryWaitaka.Exceptions.UsuarioNaoEncontradoException;
import com.waitakaLibrary.LibraryWaitaka.Service.LivroService;
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
@RequestMapping("api/v1/livros")
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Api(value = "Livro",  tags = { "Livro" })
public class LivroController {

    private LivroService livroService;

    @GetMapping
    @ApiOperation(value = "Retonar todos os Livros",
            notes = "Este endpoint retorna todos os livros")
    public List<LivroDTO> listar(){
        return livroService.listar();
    }

    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Cadastrar o Livro",
            notes = "Este endpoint recebe um Livro com os parâmetros: Titulo, Autor, Editora, Edicao, lancamento")
    public ResponseEntity<LivroDTO> cadastrar(@RequestBody @Valid LivroForm livroForm, UriComponentsBuilder uriBuilder)
            throws UsuarioNaoEncontradoException {
        return livroService.cadastrar(livroForm, uriBuilder);
    }
    @PutMapping("{titulo}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ApiOperation(value = "Atualizar o Livro",
            notes = "Este endpoint recebe um titulo e atualiza o livro correspondente a esse titulo, "+
                    "usando o(s) parâmetro(s) enviado(s).")
    public ResponseEntity<LivroDTO> atualizarPorNome(@PathVariable @Valid String titulo, @RequestBody LivroDTO livroDTO)
            throws LivroNaoLocalizadoException {
        return livroService.atualizarPorTitulo(titulo, livroDTO);
    }

    @DeleteMapping("{titulo}")
    @Transactional
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Deletar um Livro",
            notes = "Este endpoint recebe um titulo e deleta o Livro referente a esse titulo.")
    public ResponseEntity<LivroDTO> deletaPorNome(@PathVariable @Valid String titulo) throws LivroNaoLocalizadoException {
        return livroService.deletarPorTitulo(titulo);
    }
}
