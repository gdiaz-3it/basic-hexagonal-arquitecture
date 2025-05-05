package com.service3it.mscv_tritianos.infraestructure.adapters.in.rest.mapper;

import com.service3it.mscv_tritianos.domain.models.TritianosLenguajes;
import com.service3it.mscv_tritianos.infraestructure.adapters.in.rest.dto.TritianosLenguajesDto;

public class TritianosLenguajesDtoToDomainMapper {

    public static TritianosLenguajes toDomain(TritianosLenguajesDto tritianosLenguajesDto) {
        return new TritianosLenguajes(
                tritianosLenguajesDto.getId(),
                tritianosLenguajesDto.getRut(),
                tritianosLenguajesDto.getNivel()
        );
    }

    public static TritianosLenguajesDto toDto(TritianosLenguajes tritianosLenguajes) {
        return new TritianosLenguajesDto(
                tritianosLenguajes.getId(),
                tritianosLenguajes.getRut(),
                tritianosLenguajes.getNivel()
        );
    }

}
