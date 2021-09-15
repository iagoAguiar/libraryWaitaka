package com.waitakaLibrary.LibraryWaitaka.Repository;

import com.waitakaLibrary.LibraryWaitaka.Entities.Aluguel;



import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface AluguelRepository extends MongoRepository<Aluguel,String> {


    Optional<Aluguel> findByLivroTitulo(String titulo);




}
