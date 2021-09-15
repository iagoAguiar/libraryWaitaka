package com.waitakaLibrary.LibraryWaitaka.Repository;


import com.waitakaLibrary.LibraryWaitaka.Entities.Livros;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface LivroRepository extends MongoRepository<Livros,String> {

    Optional<Livros> findByTitulo(String titulo);



}
