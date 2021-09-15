package com.waitakaLibrary.LibraryWaitaka.Entities.Form;

import lombok.Data;

@Data
public class AluguelForm {



    private String titulo;
    private String email;





    public AluguelForm(
            String titulo,
            String email
    ) {

       this.titulo = titulo;
        this.email = email;


    }




}
