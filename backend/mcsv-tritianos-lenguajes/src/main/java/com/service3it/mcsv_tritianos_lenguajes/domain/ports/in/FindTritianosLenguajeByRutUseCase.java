package com.service3it.mcsv_tritianos_lenguajes.domain.ports.in;

import java.util.List;

import com.service3it.mcsv_tritianos_lenguajes.domain.models.TritianosLenguaje;

public interface FindTritianosLenguajeByRutUseCase {

    List <TritianosLenguaje> findTritianosLenguajesByRut(String rut);

}
