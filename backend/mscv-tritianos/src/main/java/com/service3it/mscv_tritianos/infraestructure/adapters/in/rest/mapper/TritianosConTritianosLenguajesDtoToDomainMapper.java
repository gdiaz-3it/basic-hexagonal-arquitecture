package com.service3it.mscv_tritianos.infraestructure.adapters.in.rest.mapper;

import java.util.stream.Collectors;

import com.service3it.mscv_tritianos.domain.models.TritianosConTritianosLenguajes;
import com.service3it.mscv_tritianos.infraestructure.adapters.in.rest.dto.TritianosConTritianosLenguajesDTO;

public class TritianosConTritianosLenguajesDtoToDomainMapper {

    public static TritianosConTritianosLenguajes toDomain(TritianosConTritianosLenguajesDTO dto) {
        return new TritianosConTritianosLenguajes(
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
                dto.getLenguajes().stream()
                        .map(TritianosLenguajesDtoToDomainMapper::toDomain)
                        .collect(Collectors.toList())
        );
    }

    public static TritianosConTritianosLenguajesDTO toDto(TritianosConTritianosLenguajes domain) {
        return new TritianosConTritianosLenguajesDTO(
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
                domain.getLenguajes().stream()
                        .map(TritianosLenguajesDtoToDomainMapper::toDto)
                        .collect(Collectors.toList())
        );
    }

}
