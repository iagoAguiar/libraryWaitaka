package com.waitakaLibrary.LibraryWaitaka.Entities.DTO;

import com.waitakaLibrary.LibraryWaitaka.Entities.Enums.Profile;
import com.waitakaLibrary.LibraryWaitaka.Entities.Funcionario;
import com.waitakaLibrary.LibraryWaitaka.Entities.Professor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioDTO extends UsuarioDTO {



    private String id;
    private String email;

    public FuncionarioDTO(Funcionario funcionario){

        this.id = funcionario.getId();
        setNome(funcionario.getNome());
        setEmail(funcionario.getEmail());
        setProfile(Profile.FUNCIONARIO);
        setCEP(funcionario.getCEP());
        setTelefone(funcionario.getTelefone());
        setMatricula(funcionario.getMatricula());
    }

    }




