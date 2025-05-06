package com.service3it.mscv_tritianos.domain.ports.out;

import java.util.List;

import com.service3it.mscv_tritianos.domain.models.TritianosAplicaciones;

public interface TritianosAplicacionesRepositoryPort {

    List<TritianosAplicaciones> findAplicacionesByRut(String rut);

    List<TritianosAplicaciones> findAplicacionesById(Long id);

}
