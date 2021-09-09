package com.waitakaLibrary.LibraryWaitaka.mappers;

import com.waitakaLibrary.LibraryWaitaka.Entities.DTO.EstudanteDTO;
import com.waitakaLibrary.LibraryWaitaka.Entities.Estudante;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EstudanteMapper {

    EstudanteMapper INSTANCE = Mappers.getMapper(EstudanteMapper.class);

    Estudante toModel(EstudanteDTO dto);

    EstudanteDTO toDTO(Estudante estudante);
}
