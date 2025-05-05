package com.service3it.mcsv_tritianos_lenguajes.infraestructure.adapters.in.rest.mapper;

import com.service3it.mcsv_tritianos_lenguajes.domain.models.TritianosLenguaje;
import com.service3it.mcsv_tritianos_lenguajes.infraestructure.adapters.in.rest.dto.TritianosLenguajeDTO;

public class TritianosLenguajeDtoToDomainMapper {

    public static TritianosLenguaje toDomain(TritianosLenguajeDTO tritianosLenguajeDTO) {
        return new TritianosLenguaje(
                tritianosLenguajeDTO.getId(),
                tritianosLenguajeDTO.getRut(),
                tritianosLenguajeDTO.getNivel()
        );
    }

    public static TritianosLenguajeDTO toDto(TritianosLenguaje tritianosLenguaje) {
        return new TritianosLenguajeDTO(
                tritianosLenguaje.getId(),
                tritianosLenguaje.getRut(),
                tritianosLenguaje.getNivel()
        );
    }

}
