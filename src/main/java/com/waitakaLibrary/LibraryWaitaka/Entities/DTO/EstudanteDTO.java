package com.waitakaLibrary.LibraryWaitaka.Entities.DTO;

import com.waitakaLibrary.LibraryWaitaka.Entities.Estudante;
import com.waitakaLibrary.LibraryWaitaka.Entities.Profile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EstudanteDTO extends UsuarioDTO {



    private String id;
    private Profile profile = Profile.ESTUDANTE;
    private String email;

    public EstudanteDTO(Estudante estudante){
        this.id = estudante.getId();
        setNome(estudante.getNome());
        setEmail(estudante.getEmail());
        setProfile(estudante.getProfile());
        setCEP(estudante.getCEP());
        setTelefone(estudante.getTelefone());
        setMatricula(estudante.getMatricula());
    }

    }




