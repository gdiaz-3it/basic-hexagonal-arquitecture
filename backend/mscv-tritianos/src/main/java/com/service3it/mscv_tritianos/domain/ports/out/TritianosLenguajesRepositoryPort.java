package com.service3it.mscv_tritianos.domain.ports.out;

import java.util.List;

import com.service3it.mscv_tritianos.domain.models.TritianosLenguajes;

public interface TritianosLenguajesRepositoryPort {

    List<TritianosLenguajes> findLenguajesByRut(String rut);

    List<TritianosLenguajes> findLenguajesById(Long id);

}
