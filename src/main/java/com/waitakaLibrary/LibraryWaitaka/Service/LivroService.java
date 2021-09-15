package com.waitakaLibrary.LibraryWaitaka.Service;

import com.waitakaLibrary.LibraryWaitaka.Entities.*;
import com.waitakaLibrary.LibraryWaitaka.DTO.LivroDTO;
import com.waitakaLibrary.LibraryWaitaka.Entities.Form.LivroForm;
import com.waitakaLibrary.LibraryWaitaka.Exceptions.LivroNaoLocalizadoException;

import com.waitakaLibrary.LibraryWaitaka.Repository.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class LivroService {

    private final LivroRepository livroRepository;



    public List<LivroDTO> listar(){
        List<Livro> livros = livroRepository.findAll();
        List<LivroDTO> livrosDTO = livros.stream().map(model -> new LivroDTO(model)).collect(Collectors.toList());

        return livrosDTO;
    }

  public LivroDTO cadastrar(Livro livro){
        livroRepository.insert(livro);
      LivroDTO livroDTO = new LivroDTO(livro);
        return livroDTO;

    }

    public ResponseEntity<LivroDTO> cadastrar(LivroForm livroForm, UriComponentsBuilder uriBuilder ){


        Livro livro = livroForm.toLivro();

        livroRepository.insert(livro);
        LivroDTO livroDTO = new LivroDTO(livro);
            URI uri = uriBuilder.path("api/v1/livros/{titulo}").buildAndExpand(livro.getTitulo()).toUri();

            return ResponseEntity.created(uri).body(livroDTO);


    }

    public Livro getLivro(LivroForm livroForm) throws LivroNaoLocalizadoException {

        Optional<Livro> livro = livroRepository.findByTitulo(livroForm.getTitulo());
        if(livro.isPresent()) {
            Livro usuario = livro.get();
            return usuario;

        } else{
            throw new LivroNaoLocalizadoException(livro.get().getTitulo());
        }
    }

    public ResponseEntity<LivroDTO> atualizarPorTitulo(String titulo, LivroDTO livroDTO) throws LivroNaoLocalizadoException {


        Livro livroParaSalvar = verificarSeExiste(titulo);

        if (livroDTO.getTitulo() != null){
            livroParaSalvar.setTitulo(livroDTO.getTitulo());
        }
        if (livroDTO.getAutor() != null){
            livroParaSalvar.setAutor(livroDTO.getAutor());
        }
        if (livroDTO.getEditora() != null){
            livroParaSalvar.setEditora(livroDTO.getEditora());
        }
        if (livroDTO.getLancamento() != null){
            livroParaSalvar.setLancamento(livroDTO.getLancamento());
        }
        if (livroDTO.getEdicao() != null){
            livroParaSalvar.setEdicao(livroDTO.getEdicao());
        }


        Livro livroSalvo = livroRepository.save(livroParaSalvar);
        LivroDTO livroSalvoDTO = new LivroDTO(livroSalvo);
        return ResponseEntity.ok(livroSalvoDTO);

    }
    public ResponseEntity<LivroDTO> deletarPorTitulo(String titulo) throws LivroNaoLocalizadoException {
        Livro livroParaDeletar = verificarSeExiste(titulo);
        livroRepository.deleteById(livroParaDeletar.getId());
        LivroDTO livroDeletadoDTO = new LivroDTO(livroParaDeletar);
        return ResponseEntity.ok(livroDeletadoDTO);

    }


    private Livro verificarSeExiste(String titulo) throws LivroNaoLocalizadoException {
        Optional<Livro> livro =  livroRepository.findByTitulo(titulo);
        if(livro.isEmpty()){
            throw new LivroNaoLocalizadoException(titulo);
        }
        return livro.get();
    }


}





