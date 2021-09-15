package com.waitakaLibrary.LibraryWaitaka.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@Document
public class Livros {

    @Id
    private String id;

    @Indexed(unique = true)
    @NotNull(message = "Titulo não pode ser vazio")
    String titulo;

    @NotNull(message = "Autor não pode ser vazio")
    private String autor;

    @NotNull(message = "Editora não pode ser vazia")
    private String editora;

    @NotNull(message = "Data de lançamento não pode ser vazia")
    private String lancamento;

    @NotNull(message = "Edição não pode ser vazia")
    private String edicao;

    @PersistenceConstructor
    public Livros(String titulo, String autor, String editora, String lancamento, String edicao) {
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.lancamento = lancamento;
        this.edicao = edicao;
    }
}
