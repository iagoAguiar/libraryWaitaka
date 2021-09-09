package com.waitakaLibrary.LibraryWaitaka.Entities.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
abstract class UsuarioDTO {

    private String nome;
    private String telefone;
    private Integer matricula;
    private String CEP;


}
