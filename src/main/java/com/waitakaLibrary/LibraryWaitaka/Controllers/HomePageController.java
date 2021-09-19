package com.waitakaLibrary.LibraryWaitaka.Controllers;


import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@Api(value = "Home Page",  tags = { "Home Page" })

public class HomePageController {
    @GetMapping
    public String getHomePage(){
        return "Bem vindo(a) a página inicial!!";
    }
}
