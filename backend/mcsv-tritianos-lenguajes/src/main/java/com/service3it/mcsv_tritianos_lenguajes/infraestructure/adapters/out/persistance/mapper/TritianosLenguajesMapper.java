package com.service3it.mcsv_tritianos_lenguajes.infraestructure.adapters.out.persistance.mapper;

import com.service3it.mcsv_tritianos_lenguajes.domain.models.TritianosLenguaje;
import com.service3it.mcsv_tritianos_lenguajes.infraestructure.adapters.in.rest.dto.TritianosLenguajeResponseDTO;
import com.service3it.mcsv_tritianos_lenguajes.infraestructure.adapters.out.persistance.entities.TritianosLenguajeEntity;

public class TritianosLenguajesMapper {

    public static TritianosLenguajeEntity toEntity(TritianosLenguaje tritianosLenguaje) {
        return new TritianosLenguajeEntity(
                tritianosLenguaje.getId(),
                tritianosLenguaje.getNivel(),
                tritianosLenguaje.getLenguaje(),
                tritianosLenguaje.getClienteId()
        );
    }

    public static TritianosLenguaje toDomain(TritianosLenguajeEntity tritianosLenguajeEntity) {
        return new TritianosLenguaje(
                tritianosLenguajeEntity.getId(),
                tritianosLenguajeEntity.getNivel(),
                tritianosLenguajeEntity.getLenguaje(),
                tritianosLenguajeEntity.getClienteId()
        );
    }

    public static TritianosLenguajeResponseDTO toResponseDto(TritianosLenguaje tritianosLenguaje) {
        return new TritianosLenguajeResponseDTO(
                tritianosLenguaje.getId(),
                tritianosLenguaje.getNivel(),
                tritianosLenguaje.getLenguaje()
        );
    }

    public static void updateTritianosLenguajeEntityFromDomain(TritianosLenguajeEntity tritianosLenguajeEntity, TritianosLenguaje tritianosLenguaje) {
        if (tritianosLenguaje.getNivel() != null) {
            tritianosLenguajeEntity.setNivel(tritianosLenguaje.getNivel());
        }
        if (tritianosLenguaje.getLenguaje() != null) {
            tritianosLenguajeEntity.setLenguaje(tritianosLenguaje.getLenguaje());
        }
    }

}
