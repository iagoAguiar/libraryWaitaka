package com.waitakaLibrary.LibraryWaitaka.Entities.DTO;

import com.waitakaLibrary.LibraryWaitaka.Entities.Estudante;
import com.waitakaLibrary.LibraryWaitaka.Entities.Enums.Profile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EstudanteDTO extends UsuarioDTO {



    private String id;
    private String email;

    public EstudanteDTO(Estudante estudante){
        this.id = estudante.getId();
        setNome(estudante.getNome());
        setEmail(estudante.getEmail());
        setProfile(Profile.ESTUDANTE);
        setCEP(estudante.getCEP());
        setTelefone(estudante.getTelefone());
        setMatricula(estudante.getMatricula());
    }

    }




