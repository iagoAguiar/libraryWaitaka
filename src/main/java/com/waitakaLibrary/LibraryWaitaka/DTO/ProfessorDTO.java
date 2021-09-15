package com.waitakaLibrary.LibraryWaitaka.DTO;

import com.waitakaLibrary.LibraryWaitaka.Entities.Enums.Perfil;
import com.waitakaLibrary.LibraryWaitaka.Entities.Professor;
import lombok.Data;

import javax.validation.constraints.NotNull;


@Data
public class ProfessorDTO extends UsuarioDTO {

    @NotNull(message = "Email não pode ser nulo")
    private String email;

    public ProfessorDTO() {
        this.profile = Perfil.PROFESSOR;
    }

    public ProfessorDTO(
            String nome,
            String telefone,
            Integer matricula,
            String CEP,
            String email,
            Perfil profile) {
        super(nome, telefone, matricula, CEP, profile);
        this.profile = Perfil.PROFESSOR;
        this.email = email;
    }


    public ProfessorDTO(Professor professor){
        setNome(professor.getNome());
        setEmail(professor.getEmail());
        setProfile(Perfil.PROFESSOR);
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




