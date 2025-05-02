package com.service3it.mcsv_tritianos_lenguajes.domain.ports.in;

import com.service3it.mcsv_tritianos_lenguajes.domain.models.TritianosLenguaje;

public interface UpdateTritianosLenguajeByIdUseCase {

    TritianosLenguaje updateTritianosLenguajeById(Long id, TritianosLenguaje tritianosLenguaje);

}
