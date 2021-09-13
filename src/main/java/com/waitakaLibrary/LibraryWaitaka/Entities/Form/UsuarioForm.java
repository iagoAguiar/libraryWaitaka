package com.waitakaLibrary.LibraryWaitaka.Entities.Form;

import com.waitakaLibrary.LibraryWaitaka.Entities.Aluguel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioForm {

    private String nome;
    private String telefone;
    private Integer matricula;
    private String CEP;
    private String email;




}
