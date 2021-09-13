package com.waitakaLibrary.LibraryWaitaka.Repository;

import com.waitakaLibrary.LibraryWaitaka.Entities.Aluguel;
import com.waitakaLibrary.LibraryWaitaka.Entities.Estudante;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AluguelRepository extends MongoRepository<Aluguel,String> {}
