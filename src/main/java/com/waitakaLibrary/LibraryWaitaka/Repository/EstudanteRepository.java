package com.waitakaLibrary.LibraryWaitaka.Repository;

import com.waitakaLibrary.LibraryWaitaka.Entities.Estudante;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface EstudanteRepository extends MongoRepository<Estudante,String>{

    Optional<Estudante> findByEmail(String email);
}
