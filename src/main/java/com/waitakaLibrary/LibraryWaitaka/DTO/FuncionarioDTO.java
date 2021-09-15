package com.waitakaLibrary.LibraryWaitaka.DTO;

import com.waitakaLibrary.LibraryWaitaka.Entities.Enums.Profile;
import com.waitakaLibrary.LibraryWaitaka.Entities.Funcionario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioDTO extends UsuarioDTO {





    private String email;




    public FuncionarioDTO(Funcionario funcionario){

        setNome(funcionario.getNome());
        setEmail(funcionario.getEmail());
        setProfile(Profile.FUNCIONARIO);
        setCEP(funcionario.getCEP());
        setTelefone(funcionario.getTelefone());
        setMatricula(funcionario.getMatricula());
    }

    public Funcionario toFuncionario(){
        return new Funcionario(
                this.getNome(),
                this.getEmail(),
                this.getTelefone(),
                this.getMatricula(),
                this.getCEP()
        );
    }

    }




