package com.waitakaLibrary.LibraryWaitaka.Repository;


import com.waitakaLibrary.LibraryWaitaka.Entities.Livro;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface LivroRepository extends MongoRepository<Livro,String> {

    Optional<Livro> findByTitulo(String titulo);



}
