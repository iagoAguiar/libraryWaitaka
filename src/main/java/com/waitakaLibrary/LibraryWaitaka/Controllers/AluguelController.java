package com.waitakaLibrary.LibraryWaitaka.Controllers;

import com.waitakaLibrary.LibraryWaitaka.Entities.Aluguel;
import com.waitakaLibrary.LibraryWaitaka.DTO.AluguelDTO;
import com.waitakaLibrary.LibraryWaitaka.Entities.Form.AluguelForm;
import com.waitakaLibrary.LibraryWaitaka.Exceptions.LivroNaoLocalizadoException;
import com.waitakaLibrary.LibraryWaitaka.Exceptions.UsuarioNaoEncontradoException;
import com.waitakaLibrary.LibraryWaitaka.Service.AluguelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
@Api(value = "Aluguel",  tags = { "Aluguel" })
public class AluguelController {

    private AluguelService aluguelService;

    @ApiOperation(value = "Retonar todos os alugueis",
            notes = "Este endpoint retorna todos os alugueis, sendo eles uma junção " +
                    "dos usuários que estão com os livros e o livro em si")
    @GetMapping
    public List<AluguelDTO> listar(){return aluguelService.listar();}

    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Cadastrar os alugueis",
            notes = "Este endpoint recebe um titulo de um livro e um e-mail, e ele então cadastra o aluguel, sendo dois"+
    " objetos, um Livro e o Usuario, seja Professor, Estudante ou Funcionario")
    public ResponseEntity<AluguelDTO> cadastrar(@RequestBody @Valid AluguelForm aluguelForm, UriComponentsBuilder uriBuilder) throws UsuarioNaoEncontradoException, LivroNaoLocalizadoException {
         return aluguelService.cadastrar(aluguelForm.getTitulo(), aluguelForm.getEmail(), uriBuilder);
    }


    @DeleteMapping("{titulo}")
    @Transactional
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Deletar o aluguel",
    notes = "Este endpoint recebe um titulo e deleta o aluguel utilizando esse titulo.")
    public ResponseEntity<AluguelDTO> deletaPorTituloLivro(@PathVariable @Valid String titulo) throws LivroNaoLocalizadoException {
        return aluguelService.deletarPorTituloLivro(titulo);
    }


}
