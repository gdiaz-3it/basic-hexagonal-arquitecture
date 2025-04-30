package com.service3it.mcsv_lenguajes.infraestructure.adapters.out.persistance.mapper;

import com.service3it.mcsv_lenguajes.domain.models.Lenguajes;
import com.service3it.mcsv_lenguajes.infraestructure.adapters.out.persistance.entities.LenguajesEntity;

public class LenguajesMapper {

    public static LenguajesEntity toEntity(Lenguajes lenguajes) {
        return new LenguajesEntity(
                lenguajes.getId(),
                lenguajes.getNombre(),
                lenguajes.getNivel()
        );
    }

    public static Lenguajes toDomain(LenguajesEntity lenguajesEntity) {
        return new Lenguajes(
                lenguajesEntity.getId(),
                lenguajesEntity.getNombre(),
                lenguajesEntity.getNivel()
        );
    }

    public static void updateEntityFromDomain(LenguajesEntity lenguajesEntity, Lenguajes lenguajes) {
        if (lenguajes.getNombre() != null) {
            lenguajesEntity.setNombre(lenguajes.getNombre());
        } 
        if (lenguajes.getNivel() != null) {
            lenguajesEntity.setNivel(lenguajes.getNivel());
        }
    }

}
