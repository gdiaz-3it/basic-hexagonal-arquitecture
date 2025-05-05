package com.service3it.mscv_tritianos.infraestructure.adapters.in.rest.mapper;

import java.util.stream.Collectors;

import com.service3it.mscv_tritianos.domain.models.TritianosConTritianosAplicaciones;
import com.service3it.mscv_tritianos.infraestructure.adapters.in.rest.dto.TritianosConTritianoAplicacionesDTO;

public class TritianosConTritianosAplicacionesDtoToDomainMapper {

    public static TritianosConTritianosAplicaciones toDomain(TritianosConTritianoAplicacionesDTO dto) {
        return new TritianosConTritianosAplicaciones(
                dto.getId(),
                dto.getNombre(),
                dto.getApellido(),
                dto.getCorreoElectronico(),
                dto.getRut(),
                dto.getTelefono(),
                dto.getEstado(),
                dto.getEnlaceBizneo(),
                dto.getEnlaceHubspot(),
                dto.getEnlaceJira(),
                dto.getAplicaciones().stream()
                        .map(TritianosAplicacionesDtoToDomainMapper::toDomain)
                        .collect(Collectors.toList())
        );
    }

    public static TritianosConTritianoAplicacionesDTO toDto(TritianosConTritianosAplicaciones domain) {
        return new TritianosConTritianoAplicacionesDTO(
                domain.getId(),
                domain.getNombre(),
                domain.getApellido(),
                domain.getCorreoElectronico(),
                domain.getRut(),
                domain.getTelefono(),
                domain.getEstado(),
                domain.getEnlaceBizneo(),
                domain.getEnlaceHubspot(),
                domain.getEnlaceJira(),
                domain.getAplicaciones().stream()
                        .map(TritianosAplicacionesDtoToDomainMapper::toDto)
                        .collect(Collectors.toList())
        );
    }



}
