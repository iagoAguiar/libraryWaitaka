package com.waitakaLibrary.LibraryWaitaka.Controllers;

import com.waitakaLibrary.LibraryWaitaka.Entities.Estudante;
import com.waitakaLibrary.LibraryWaitaka.Service.EstudanteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController
@RequestMapping("/estudantes")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EstudanteController {

    private EstudanteService estudanteService;

    @GetMapping
    public List<Estudante> listar(){
        return estudanteService.lista();
    }
}
