package com.waitakaLibrary.LibraryWaitaka.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class LivroNaoLocalizadoHandler extends  Exception{

    public LivroNaoLocalizadoHandler(String titulo){
        super(String.format("Livro: %s não foi localizado!", titulo));
    }
}
