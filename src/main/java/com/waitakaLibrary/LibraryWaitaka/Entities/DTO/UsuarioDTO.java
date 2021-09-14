package com.waitakaLibrary.LibraryWaitaka.Entities.DTO;


import com.waitakaLibrary.LibraryWaitaka.Entities.Enums.Profile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
abstract class UsuarioDTO {

    @NotNull(message ="Nome não pode ser nulo")
    private String nome;
    @NotNull(message ="Telefone não pode ser nulo")
    private String telefone;
    @NotNull(message ="Matricula não pode ser nulo")
    private Integer matricula;
    @NotNull(message ="CEP não pode ser nulo")
    private String CEP;

    private Profile profile;


}
