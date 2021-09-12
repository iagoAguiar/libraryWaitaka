package com.waitakaLibrary.LibraryWaitaka.Entities.DTO;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.waitakaLibrary.LibraryWaitaka.Entities.Aluguel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AluguelDTO {


    private String titulo;

    private String autor;

    private String editora;

    private String edicao;

    private String diaAluguel;

    private String dataRenovacao;

    private String lancamento;

    @JsonProperty("Usuario")
    private UsuarioDTO locatario;





//    public AluguelDTO(
//            String titulo,
//            String autor,
//            String editora,
//            String diaAluguel,
//            String lancamento,
//            String dataRenovacao,
//            String edicao,
//            UsuarioDTO locatario) {
//        this.titulo = titulo;
//        this.autor = autor;
//        this.editora = editora;
//        this.locatario = locatario;
//        this.edicao = edicao.toString();
//        this.lancamento = lancamento;
//        this.diaAluguel = diaAluguel;
//        this.dataRenovacao = dataRenovacao;
//
//
//    }




}






