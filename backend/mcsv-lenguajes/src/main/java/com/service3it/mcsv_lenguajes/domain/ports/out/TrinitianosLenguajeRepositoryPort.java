package com.service3it.mcsv_lenguajes.domain.ports.out;

import java.util.List;

import com.service3it.mcsv_lenguajes.domain.models.TrinitianosLenguaje;

public interface TrinitianosLenguajeRepositoryPort {

    List<TrinitianosLenguaje> getAllTrinitianosLenguaje();

    TrinitianosLenguaje getTrinitianosLenguajeById(Long id);

    TrinitianosLenguaje saveTrinitianosLenguaje(TrinitianosLenguaje trinitianosLenguaje);

    TrinitianosLenguaje updateTrinitianosLenguajeById(Long id, TrinitianosLenguaje trinitianosLenguaje);

    void deleteTrinitianosLenguajeById(Long id);
}
