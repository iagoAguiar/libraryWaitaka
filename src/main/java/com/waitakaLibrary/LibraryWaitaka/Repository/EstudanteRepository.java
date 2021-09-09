package com.waitakaLibrary.LibraryWaitaka.Repository;

import com.waitakaLibrary.LibraryWaitaka.Entities.Estudante;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EstudanteRepository extends MongoRepository<Estudante,String> {}
