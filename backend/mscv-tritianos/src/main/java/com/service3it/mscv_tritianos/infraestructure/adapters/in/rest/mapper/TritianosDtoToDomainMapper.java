package com.service3it.mscv_tritianos.infraestructure.adapters.in.rest.mapper;

import com.service3it.mscv_tritianos.domain.models.Tritianos;
import com.service3it.mscv_tritianos.infraestructure.adapters.in.rest.dto.TritianosDTO;

public class TritianosDtoToDomainMapper {

    public static Tritianos toDomain(TritianosDTO dto) {
        return new Tritianos(
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
                null,
                null
        );
    }

    public static TritianosDTO toDto(Tritianos domain) {
        return new TritianosDTO(
                domain.getId(),
                domain.getNombre(),
                domain.getApellido(),
                domain.getCorreoElectronico(),
                domain.getRut(),
                domain.getTelefono(),
                domain.getEstado(),
                domain.getEnlaceBizneo(),
                domain.getEnlaceHubspot(),
                domain.getEnlaceJira()
        );
    }
}