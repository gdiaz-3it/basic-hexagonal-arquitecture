package com.service3it.mscv_tritianos.infraestructure.adapters.out.persistance.mapper;

import com.service3it.mscv_tritianos.domain.models.TritianosLenguajes;
import com.service3it.mscv_tritianos.infraestructure.adapters.in.rest.dto.TritianosLenguajesDto;

public class TritianosLenguajesMapper {

    public static TritianosLenguajes toDomain(TritianosLenguajesDto tritianosLenguajesDto) {
        return new TritianosLenguajes(
                tritianosLenguajesDto.getId(),
                tritianosLenguajesDto.getRut(),
                tritianosLenguajesDto.getNivel()
        );
    }

}
