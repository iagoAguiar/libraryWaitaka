package com.waitakaLibrary.LibraryWaitaka.DTO;

import com.waitakaLibrary.LibraryWaitaka.Entities.Enums.Profile;
import com.waitakaLibrary.LibraryWaitaka.Entities.Professor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


@Data
public class ProfessorDTO extends UsuarioDTO {

    @NotNull(message = "Email não pode ser nulo")
    private String email;

    public ProfessorDTO() {
        this.profile = Profile.PROFESSOR;
    }

    public ProfessorDTO(
            String nome,
            String telefone,
            Integer matricula,
            String CEP,
            String email,
            Profile profile) {
        super(nome, telefone, matricula, CEP, profile);
        this.profile = Profile.PROFESSOR;
        this.email = email;
    }


    public ProfessorDTO(Professor professor){
        setNome(professor.getNome());
        setEmail(professor.getEmail());
        setProfile(Profile.PROFESSOR);
        setCEP(professor.getCEP());
        setTelefone(professor.getTelefone());
        setMatricula(professor.getMatricula());
    }

    public Professor toProfessor(){
        return new Professor(
                this.getNome(),
                this.getEmail(),
                this.getTelefone(),
                this.getMatricula(),
                this.getCEP()
        );
    }



    }




