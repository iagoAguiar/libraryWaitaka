package com.waitakaLibrary.LibraryWaitaka.Entities.Enums;

import com.waitakaLibrary.LibraryWaitaka.Entities.Usuario;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public enum Profile {

    PROFESSOR, ESTUDANTE, FUNCIONARIO;



    public static String defineDatas(Usuario locatario) {

        LocalDateTime diaAluguel = LocalDateTime.now();
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("dd/MM/yyy");
        String dataRenovacao = "";

        switch (locatario.getProfile()){
            case ESTUDANTE:
                dataRenovacao = diaAluguel.plusDays(7).format(format1);
                break;
            case FUNCIONARIO:
                dataRenovacao = diaAluguel.plusDays(10).format(format1);
                break;
            case PROFESSOR:
                dataRenovacao = diaAluguel.plusDays(14).format(format1);
                break;
        }

        return dataRenovacao;
    }



}
