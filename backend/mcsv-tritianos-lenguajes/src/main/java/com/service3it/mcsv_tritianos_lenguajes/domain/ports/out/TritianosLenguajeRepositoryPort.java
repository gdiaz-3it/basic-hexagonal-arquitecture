package com.service3it.mcsv_tritianos_lenguajes.domain.ports.out;

import java.util.List;

import com.service3it.mcsv_tritianos_lenguajes.domain.models.TritianosLenguaje;

public interface TritianosLenguajeRepositoryPort {

    List<TritianosLenguaje> getAllTritianosLenguaje();

    TritianosLenguaje getTritianosLenguajeById(Long id);

    TritianosLenguaje saveTritianosLenguaje(TritianosLenguaje tritianosLenguaje);

    TritianosLenguaje updateTritianosLenguajeById(Long id, TritianosLenguaje tritianosLenguaje);

    void deleteTritianosLenguajeById(Long id);

    List<TritianosLenguaje> findTritianosLenguajesByRut(String rut);

}
