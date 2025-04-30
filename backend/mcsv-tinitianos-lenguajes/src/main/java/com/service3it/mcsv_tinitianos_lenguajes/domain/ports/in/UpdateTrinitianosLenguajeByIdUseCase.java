package com.service3it.mcsv_tinitianos_lenguajes.domain.ports.in;

import com.service3it.mcsv_tinitianos_lenguajes.domain.models.TrinitianosLenguaje;

public interface UpdateTrinitianosLenguajeByIdUseCase {

    TrinitianosLenguaje updateTrinitianosLenguajeById(Long id, TrinitianosLenguaje trinitianosLenguaje);

}
