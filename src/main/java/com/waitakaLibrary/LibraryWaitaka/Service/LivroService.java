package com.waitakaLibrary.LibraryWaitaka.Service;

import com.waitakaLibrary.LibraryWaitaka.Entities.*;
import com.waitakaLibrary.LibraryWaitaka.Entities.DTO.LivroDTO;
import com.waitakaLibrary.LibraryWaitaka.Entities.Form.LivroForm;
import com.waitakaLibrary.LibraryWaitaka.Exceptions.LivroNaoLocalizadoHandler;

import com.waitakaLibrary.LibraryWaitaka.Repository.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class LivroService {

    private final LivroRepository livroRepository;



    public List<Livros> lista(){
        return livroRepository.findAll();
    }

  public LivroDTO cadastrar(Livros livro){
        livroRepository.insert(livro);
      LivroDTO livroDTO = new LivroDTO(livro);
        return livroDTO;

    }

    public ResponseEntity<LivroDTO> cadastrar(LivroForm livroForm, UriComponentsBuilder uriBuilder ){


        Livros livro = livroForm.toLivro();

        livroRepository.insert(livro);
        LivroDTO livroDTO = new LivroDTO(livro);
            URI uri = uriBuilder.path("api/v1/livros/{titulo}").buildAndExpand(livro.getTitulo()).toUri();

            return ResponseEntity.created(uri).body(livroDTO);


    }

    public Livros getLivro(LivroForm livroForm) throws LivroNaoLocalizadoHandler {

        Optional<Livros> livro = livroRepository.findByTitulo(livroForm.getTitulo());
        if(livro.isPresent()) {
            Livros usuario = livro.get();
            return usuario;

        } else{
            throw new LivroNaoLocalizadoHandler(livro.get().getTitulo());
        }
    }

    public ResponseEntity<LivroDTO> atualizarPorTitulo(String titulo, LivroDTO livroDTO) throws LivroNaoLocalizadoHandler {


        Livros livroParaSalvar = verificarSeExiste(titulo);

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


        Livros livroSalvo = livroRepository.save(livroParaSalvar);
        LivroDTO livroSalvoDTO = new LivroDTO(livroSalvo);
        return ResponseEntity.ok(livroSalvoDTO);

    }
    public ResponseEntity<LivroDTO> deletaPorTitulo(String titulo) throws LivroNaoLocalizadoHandler {
        Livros livroParaDeletar = verificarSeExiste(titulo);
        livroRepository.deleteById(livroParaDeletar.getId());
        LivroDTO livroDeletadoDTO = new LivroDTO(livroParaDeletar);
        return ResponseEntity.ok(livroDeletadoDTO);

    }


    private Livros verificarSeExiste(String titulo) throws LivroNaoLocalizadoHandler {
        Optional<Livros> livro =  livroRepository.findByTitulo(titulo);
        if(livro.isEmpty()){
            throw new LivroNaoLocalizadoHandler(titulo);
        }
        return livro.get();
    }


}





