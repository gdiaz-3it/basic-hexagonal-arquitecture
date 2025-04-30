package com.service3it.mcsv_tinitianos_lenguajes.infraestructure.adapters.out.persistance.mapper;

import com.service3it.mcsv_tinitianos_lenguajes.domain.models.TrinitianosLenguaje;
import com.service3it.mcsv_tinitianos_lenguajes.infraestructure.adapters.out.persistance.entities.TrinitianosLenguajeEntity;

public class TrinitianosLenguajesMapper {

    public static TrinitianosLenguajeEntity toEntity(TrinitianosLenguaje trinitianosLenguaje) {
        return new TrinitianosLenguajeEntity(
                trinitianosLenguaje.getId(),
                trinitianosLenguaje.getDescripcion()
        );
    }

    public static TrinitianosLenguaje toDomain(TrinitianosLenguajeEntity trinitianosLenguajeEntity) {
        return new TrinitianosLenguaje(
                trinitianosLenguajeEntity.getId(),
                trinitianosLenguajeEntity.getDescripcion()
        );
    }

    public static void updateTrinitianosLenguajeEntityFromDomain(TrinitianosLenguajeEntity trinitianosLenguajeEntity, TrinitianosLenguaje trinitianosLenguaje) {
        if (trinitianosLenguaje.getDescripcion() != null) {
            trinitianosLenguajeEntity.setDescripcion(trinitianosLenguaje.getDescripcion());
        }
    }

}
