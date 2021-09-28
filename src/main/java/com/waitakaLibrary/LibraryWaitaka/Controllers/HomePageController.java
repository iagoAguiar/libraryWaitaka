package com.waitakaLibrary.LibraryWaitaka.Controllers;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/")
@Api(value = "Home Page",  tags = { "Home Page" })

public class HomePageController {
    @GetMapping
@ApiOperation(value = "Redireciona para o Swagger",
        notes = "Este endpoint redireciona o get da página inicial para o Swaager")
public RedirectView goToSwagger() {
    return new RedirectView("swagger-ui.html");
}
}
