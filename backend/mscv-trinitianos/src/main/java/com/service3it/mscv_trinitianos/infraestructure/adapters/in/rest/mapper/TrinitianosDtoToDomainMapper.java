package com.service3it.mscv_trinitianos.infraestructure.adapters.in.rest.mapper;

import com.service3it.mscv_trinitianos.domain.models.Trinitianos;
import com.service3it.mscv_trinitianos.infraestructure.adapters.in.rest.dto.TrinitianosDTO;

public class TrinitianosDtoToDomainMapper {

    public static Trinitianos toDomain(TrinitianosDTO dto) {
        return new Trinitianos(
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

    public static TrinitianosDTO toDto(Trinitianos domain) {
        return new TrinitianosDTO(
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