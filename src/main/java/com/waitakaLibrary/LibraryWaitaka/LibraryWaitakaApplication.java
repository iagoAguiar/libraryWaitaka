package com.waitakaLibrary.LibraryWaitaka;

import com.waitakaLibrary.LibraryWaitaka.Entities.Estudante;
import com.waitakaLibrary.LibraryWaitaka.Repository.EstudanteRepository;
import com.waitakaLibrary.LibraryWaitaka.Service.EstudanteService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class LibraryWaitakaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryWaitakaApplication.class, args);
	}


	@Bean
	CommandLineRunner runner(EstudanteService estudanteService, MongoTemplate mongoTemplate) {
		return args -> {
				Estudante estudante = new Estudante(
					"Iago",
					"iagoaguiar202@gmail.com",
					"22 9 9999-9999",
					1234,
					"28240-965" );
				estudanteService.cadastrar(estudante);
				estudanteService.lista();

		};

	}
}
