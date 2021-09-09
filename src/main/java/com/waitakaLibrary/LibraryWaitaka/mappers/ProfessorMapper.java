package com.waitakaLibrary.LibraryWaitaka.mappers;

import com.waitakaLibrary.LibraryWaitaka.Entities.DTO.EstudanteDTO;
import com.waitakaLibrary.LibraryWaitaka.Entities.DTO.ProfessorDTO;
import com.waitakaLibrary.LibraryWaitaka.Entities.Estudante;
import com.waitakaLibrary.LibraryWaitaka.Entities.Professor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProfessorMapper {

    ProfessorMapper INSTANCE = Mappers.getMapper(ProfessorMapper.class);

    Professor toModel(ProfessorDTO dto);

    ProfessorDTO toDTO(Professor professor);
}
