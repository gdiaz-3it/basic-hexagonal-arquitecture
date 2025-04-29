package com.service3it.mcsv_lenguajes.infraestructure.adapters.out.persistance.mapper;

import com.service3it.mcsv_lenguajes.domain.models.TrinitianosLenguaje;
import com.service3it.mcsv_lenguajes.infraestructure.adapters.out.persistance.entities.LenguajesEntity;
import com.service3it.mcsv_lenguajes.infraestructure.adapters.out.persistance.entities.TrinitianosLenguajeEntity;

public class TrinitianosLenguajesMapper {

    public static TrinitianosLenguajeEntity toEntity(TrinitianosLenguaje domain, LenguajesEntity lenguajeEntity) {
        return new TrinitianosLenguajeEntity(
                domain.getId(),
                lenguajeEntity,
                domain.getNivel()
        );
    }

    public static TrinitianosLenguaje toDomain(TrinitianosLenguajeEntity trinitianosLenguajeEntity) {
        return new TrinitianosLenguaje(
                trinitianosLenguajeEntity.getId(),
                trinitianosLenguajeEntity.getLenguajeId().getId(),
                trinitianosLenguajeEntity.getNivel()
        );
    }

    public static void updateTrinitianosLenguajeEntityFromDomain(TrinitianosLenguajeEntity trinitianosLenguajeEntity, TrinitianosLenguaje trinitianosLenguaje) {
        if (trinitianosLenguaje.getNivel() != null) {
            trinitianosLenguajeEntity.setNivel(trinitianosLenguaje.getNivel());
        }
    }

    

}
