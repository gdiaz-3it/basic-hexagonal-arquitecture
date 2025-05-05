package com.service3it.mscv_tritianos.infraestructure.adapters.in.rest.mapper;

import com.service3it.mscv_tritianos.domain.models.TritianosAplicaciones;
import com.service3it.mscv_tritianos.infraestructure.adapters.in.rest.dto.TritianosAplicacionesDto;

public class TritianosAplicacionesDtoToDomainMapper {

    public static TritianosAplicaciones toDomain(TritianosAplicacionesDto tritianosAplicacionesDto) {
        return new TritianosAplicaciones(
                tritianosAplicacionesDto.getId(),
                tritianosAplicacionesDto.getRut(),
                tritianosAplicacionesDto.getNivel()
        );
    }

    public static TritianosAplicacionesDto toDto(TritianosAplicaciones tritianosAplicaciones) {
        return new TritianosAplicacionesDto(
                tritianosAplicaciones.getId(),
                tritianosAplicaciones.getRut(),
                tritianosAplicaciones.getNivel()
        );
    }

}
