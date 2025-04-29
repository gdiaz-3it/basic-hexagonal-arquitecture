package com.service3it.mcsv_lenguajes.infraestructure.adapters.out.persistance.mapper;

import com.service3it.mcsv_lenguajes.domain.models.TrinitianosLenguaje;
import com.service3it.mcsv_lenguajes.infraestructure.adapters.out.persistance.entities.TrinitianosLenguajeEntity;

public class TrinitianosLenguajesMapper {

    public static TrinitianosLenguajeEntity toEntity(TrinitianosLenguaje trinitianosLenguaje) {
        return new TrinitianosLenguajeEntity(
                trinitianosLenguaje.getId(),
                trinitianosLenguaje.getLenguajeId(),
                trinitianosLenguaje.getNivel()
        );
    }

    public static TrinitianosLenguaje toDomain(TrinitianosLenguajeEntity trinitianosLenguajeEntity) {
        return new TrinitianosLenguaje(
                trinitianosLenguajeEntity.getId(),
                trinitianosLenguajeEntity.getLenguajeId(),
                trinitianosLenguajeEntity.getNivel()
        );
    }

    public static void updateTrinitianosLenguajeEntityFromDomain(TrinitianosLenguajeEntity trinitianosLenguajeEntity, TrinitianosLenguaje trinitianosLenguaje) {
        if (trinitianosLenguaje.getNivel() != null) {
            trinitianosLenguajeEntity.setNivel(trinitianosLenguaje.getNivel());
        }
    }

    

}
