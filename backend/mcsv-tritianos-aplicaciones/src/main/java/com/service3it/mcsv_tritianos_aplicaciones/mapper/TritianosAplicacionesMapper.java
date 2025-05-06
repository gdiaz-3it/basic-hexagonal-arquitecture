package com.service3it.mcsv_tritianos_aplicaciones.mapper;

import com.service3it.mcsv_tritianos_aplicaciones.dto.TritianosAplicacionesResponseDto;
import com.service3it.mcsv_tritianos_aplicaciones.model.TritianosAplicacionesEntity;

public class TritianosAplicacionesMapper {

    public static TritianosAplicacionesResponseDto toResponseDto(TritianosAplicacionesEntity entity) {
        TritianosAplicacionesResponseDto dto = new TritianosAplicacionesResponseDto();
        dto.setId(entity.getId());
        dto.setNivel(entity.getNivel());
        dto.setAplicacion(entity.getAplicacion());
        return dto;
    }

}
