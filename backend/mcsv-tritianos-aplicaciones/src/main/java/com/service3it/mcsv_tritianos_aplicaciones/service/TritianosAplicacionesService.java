package com.service3it.mcsv_tritianos_aplicaciones.service;

import java.util.List;

import com.service3it.mcsv_tritianos_aplicaciones.dto.TritianosAplicacionesDto;
import com.service3it.mcsv_tritianos_aplicaciones.model.TritianosAplicacionesEntity;


public interface TritianosAplicacionesService {

    Iterable<TritianosAplicacionesEntity> findAll();

    List<TritianosAplicacionesEntity> findByNivel(String nivel);

    TritianosAplicacionesEntity save(TritianosAplicacionesEntity tritianosAplicacionesEntity);

    List<TritianosAplicacionesDto> findAllTritianosAplicacionesWithAplicaciones();

    List<TritianosAplicacionesDto> findAllTritianosAplicacionesWithAplicacionByNivel(String nivel);

    List<TritianosAplicacionesEntity> findByRut(String rut);

}
