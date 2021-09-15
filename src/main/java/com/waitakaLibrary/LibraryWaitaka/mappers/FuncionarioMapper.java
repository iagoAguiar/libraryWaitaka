package com.waitakaLibrary.LibraryWaitaka.mappers;

import com.waitakaLibrary.LibraryWaitaka.DTO.FuncionarioDTO;
import com.waitakaLibrary.LibraryWaitaka.Entities.Funcionario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface FuncionarioMapper {

    FuncionarioMapper INSTANCE = Mappers.getMapper(FuncionarioMapper.class);

    Funcionario toModel(FuncionarioDTO dto);

    FuncionarioDTO toDTO(Funcionario funcionario);
}
