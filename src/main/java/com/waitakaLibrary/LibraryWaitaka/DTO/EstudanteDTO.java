package com.waitakaLibrary.LibraryWaitaka.DTO;

import com.waitakaLibrary.LibraryWaitaka.Entities.Estudante;
import com.waitakaLibrary.LibraryWaitaka.Entities.Enums.Profile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


@Data
public class EstudanteDTO extends UsuarioDTO {




    @NotNull(message = "Email não pode ser nulo")
    private String email;

    public EstudanteDTO() {
        this.profile = Profile.ESTUDANTE;
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
            Profile profile,
            String email) {
        super(nome, telefone, matricula, CEP, profile);
        this.profile = Profile.ESTUDANTE;
        this.email = email;
    }


    public EstudanteDTO(Estudante estudante){
        setNome(estudante.getNome());
        setEmail(estudante.getEmail());
        setProfile(Profile.ESTUDANTE);
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




