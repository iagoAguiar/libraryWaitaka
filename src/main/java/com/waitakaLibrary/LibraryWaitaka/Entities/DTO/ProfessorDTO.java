package com.waitakaLibrary.LibraryWaitaka.Entities.DTO;

import com.waitakaLibrary.LibraryWaitaka.Entities.Enums.Profile;
import com.waitakaLibrary.LibraryWaitaka.Entities.Estudante;
import com.waitakaLibrary.LibraryWaitaka.Entities.Professor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorDTO extends UsuarioDTO {



    private String id;
    private String email;

    public ProfessorDTO(Professor professor){
        this.id = professor.getId();
        setNome(professor.getNome());
        setEmail(professor.getEmail());
        setProfile(Profile.PROFESSOR);
        setCEP(professor.getCEP());
        setTelefone(professor.getTelefone());
        setMatricula(professor.getMatricula());
    }

    }




