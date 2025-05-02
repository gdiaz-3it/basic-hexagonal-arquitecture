package com.service3it.mcsv_tritianos_lenguajes.infraestructure.adapters.out.persistance.mapper;

import com.service3it.mcsv_tritianos_lenguajes.domain.models.TritianosLenguaje;
import com.service3it.mcsv_tritianos_lenguajes.infraestructure.adapters.out.persistance.entities.TritianosLenguajeEntity;

public class TritianosLenguajesMapper {

    public static TritianosLenguajeEntity toEntity(TritianosLenguaje tritianosLenguaje) {
        return new TritianosLenguajeEntity(
                tritianosLenguaje.getId(),
                tritianosLenguaje.getDescripcion()
        );
    }

    public static TritianosLenguaje toDomain(TritianosLenguajeEntity tritianosLenguajeEntity) {
        return new TritianosLenguaje(
                tritianosLenguajeEntity.getId(),
                tritianosLenguajeEntity.getDescripcion()
        );
    }

    public static void updateTritianosLenguajeEntityFromDomain(TritianosLenguajeEntity tritianosLenguajeEntity, TritianosLenguaje tritianosLenguaje) {
        if (tritianosLenguaje.getDescripcion() != null) {
            tritianosLenguajeEntity.setDescripcion(tritianosLenguaje.getDescripcion());
        }
    }

}
