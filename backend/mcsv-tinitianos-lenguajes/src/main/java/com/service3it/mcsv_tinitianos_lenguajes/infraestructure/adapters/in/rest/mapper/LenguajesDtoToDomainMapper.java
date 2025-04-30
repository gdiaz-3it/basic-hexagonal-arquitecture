package com.service3it.mcsv_tinitianos_lenguajes.infraestructure.adapters.in.rest.mapper;

import com.service3it.mcsv_tinitianos_lenguajes.domain.models.Lenguajes;
import com.service3it.mcsv_tinitianos_lenguajes.infraestructure.adapters.in.rest.dto.LenguajesDTO;

public class LenguajesDtoToDomainMapper {

    public static Lenguajes toDomain(LenguajesDTO lenguajesDTO) {
        return new Lenguajes(
                lenguajesDTO.getId(),
                lenguajesDTO.getNombre(),
                lenguajesDTO.getNivel()
        );
    }

    public static LenguajesDTO toDto(Lenguajes lenguajes) {
        return new LenguajesDTO(
                lenguajes.getId(),
                lenguajes.getNombre(),
                lenguajes.getNivel()
        );
    }
}
