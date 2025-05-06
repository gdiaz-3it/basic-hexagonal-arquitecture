package com.service3it.mscv_tritianos.infraestructure.adapters.out.persistance.mapper;

import com.service3it.mscv_tritianos.domain.models.TritianosAplicaciones;
import com.service3it.mscv_tritianos.infraestructure.adapters.in.rest.dto.TritianosAplicacionesDto;

public class TritianosAplicacionesMapper {

    public static TritianosAplicaciones toDomain(TritianosAplicacionesDto tritianosAplicacionesDto) {
        return new TritianosAplicaciones(
                tritianosAplicacionesDto.getId(),
                null,
                tritianosAplicacionesDto.getNivel(),
                tritianosAplicacionesDto.getAplicacion(),
                null

        );
    }

}
