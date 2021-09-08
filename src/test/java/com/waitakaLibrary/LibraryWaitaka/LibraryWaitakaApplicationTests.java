package com.waitakaLibrary.LibraryWaitaka;

import com.waitakaLibrary.LibraryWaitaka.entities.Estudante;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class LibraryWaitakaApplicationTests {

	@Test
	void testeNovoEstudante() {

		Estudante estudante = new Estudante(
				"Iago",
				"iagoaguiar202@gmail.com",
				"22 9 9999-9999",
				1234,
				"28240-965" );
		assertEquals(estudante.getNome(), "Iago");
		assertEquals(estudante.getMatricula(), 1234);
		assertEquals(estudante.getTelefone(), "22 9 9999-9999");
		assertEquals(estudante.getEmail(), "iagoaguiar202@gmail.com");
		assertEquals(estudante.getCEP(), "28240-965");


	}

}
