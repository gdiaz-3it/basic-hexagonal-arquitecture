package com.service3it.mscv_tritianos.infraestructure.adapters.out.persistance.mapper;

import java.util.List;

import com.service3it.mscv_tritianos.domain.models.Tritianos;
import com.service3it.mscv_tritianos.domain.models.TritianosConTritianosLenguajes;
import com.service3it.mscv_tritianos.domain.models.TritianosLenguajes;



public class TritianosWithTritianosLenguajesMapper {

    public static TritianosConTritianosLenguajes map (
        Tritianos tritiano,
        List<TritianosLenguajes> lenguajes
    ) {

        return new TritianosConTritianosLenguajes(
            tritiano.getId(),
            tritiano.getRut(),
            tritiano.getNombre(),
            tritiano.getApellido(),
            tritiano.getCorreoElectronico(),
            tritiano.getTelefono(),
            tritiano.getEstado(),
            tritiano.getEnlaceBizneo(),
            tritiano.getEnlaceHubspot(),
            tritiano.getEnlaceJira(),
            lenguajes
        );
    }

}
