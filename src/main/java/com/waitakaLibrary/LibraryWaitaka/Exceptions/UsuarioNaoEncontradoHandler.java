package com.waitakaLibrary.LibraryWaitaka.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UsuarioNaoEncontradoHandler extends  Exception{

    public UsuarioNaoEncontradoHandler(String email){
        super(String.format("Email: %s não foi localizado!", email));
    }
}
