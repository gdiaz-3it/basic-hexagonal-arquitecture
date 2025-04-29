package com.service3it.mcsv_lenguajes.infraestructure.adapters.in.rest.mapper;

import com.service3it.mcsv_lenguajes.domain.models.TrinitianosLenguaje;
import com.service3it.mcsv_lenguajes.infraestructure.adapters.in.rest.dto.TrinitianosLenguajeDTO;

public class TrinitianosLenguajeDtoToDomainMapper {

    public static TrinitianosLenguaje toDomain(TrinitianosLenguajeDTO trinitianosLenguajeDTO) {
        return new TrinitianosLenguaje(
                trinitianosLenguajeDTO.getId(),
                trinitianosLenguajeDTO.getLenguajeId(),
                trinitianosLenguajeDTO.getNivel()
        );
    }

    public static TrinitianosLenguajeDTO toDto(TrinitianosLenguaje trinitianosLenguaje) {
        return new TrinitianosLenguajeDTO(
                trinitianosLenguaje.getId(),
                trinitianosLenguaje.getLenguajeId(),
                trinitianosLenguaje.getNivel()
        );
    }

}
