package com.service3it.mscv_tritianos.infraestructure.adapters.out.persistance.mapper;

import java.util.List;

import com.service3it.mscv_tritianos.domain.models.Tritianos;
import com.service3it.mscv_tritianos.domain.models.TritianosAplicaciones;
import com.service3it.mscv_tritianos.domain.models.TritianosConTritianosAplicaciones;

public class TritianosWithTritianosAplicacionesMapper {

    public static TritianosConTritianosAplicaciones map (
        Tritianos tritiano,
        List<TritianosAplicaciones> aplicaciones
    ) {

        return new TritianosConTritianosAplicaciones(
            tritiano.getId(),
            tritiano.getNombre(),
            tritiano.getApellido(),
            tritiano.getCorreoElectronico(),
            tritiano.getRut(),
            tritiano.getTelefono(),
            tritiano.getEstado(),
            tritiano.getEnlaceBizneo(),
            tritiano.getEnlaceHubspot(),
            tritiano.getEnlaceJira(),
            aplicaciones
        );
    }

}
