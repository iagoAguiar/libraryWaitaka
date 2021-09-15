package com.waitakaLibrary.LibraryWaitaka.DTO;

import com.waitakaLibrary.LibraryWaitaka.Entities.Estudante;
import com.waitakaLibrary.LibraryWaitaka.Entities.Enums.Perfil;
import lombok.Data;

import javax.validation.constraints.NotNull;


@Data
public class EstudanteDTO extends UsuarioDTO {




    @NotNull(message = "Email não pode ser nulo")
    private String email;

    public EstudanteDTO() {
        this.profile = Perfil.ESTUDANTE;
    }

    public EstudanteDTO(
            @NotNull(message = "Nome não pode ser nulo")
                    String nome,
            @NotNull(message = "Telefone não pode ser nulo")
                    String telefone,
            @NotNull(message = "Matricula não pode ser nulo")
                    Integer matricula,
            @NotNull(message = "CEP não pode ser nulo")
                    String CEP,
            Perfil profile,
            String email) {
        super(nome, telefone, matricula, CEP, profile);
        this.profile = Perfil.ESTUDANTE;
        this.email = email;
    }


    public EstudanteDTO(Estudante estudante){
        setNome(estudante.getNome());
        setEmail(estudante.getEmail());
        setProfile(Perfil.ESTUDANTE);
        setCEP(estudante.getCEP());
        setTelefone(estudante.getTelefone());
        setMatricula(estudante.getMatricula());
    }

    public Estudante toEstudante(){
        return new Estudante(
                this.getNome(),
                this.getEmail(),
                this.getTelefone(),
                this.getMatricula(),
                this.getCEP()
        );
    }

    }




