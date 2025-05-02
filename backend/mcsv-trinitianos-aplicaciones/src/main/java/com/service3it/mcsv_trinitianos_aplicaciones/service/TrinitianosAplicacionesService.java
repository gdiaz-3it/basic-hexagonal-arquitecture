package com.service3it.mcsv_trinitianos_aplicaciones.service;

import java.util.List;

import com.service3it.mcsv_trinitianos_aplicaciones.dto.TrinitianosAplicacionesDto;
import com.service3it.mcsv_trinitianos_aplicaciones.model.TrinitianosAplicacionesEntity;

public interface TrinitianosAplicacionesService {

    Iterable<TrinitianosAplicacionesEntity> findAll();

    List<TrinitianosAplicacionesEntity> findByNivel(String nivel);

    TrinitianosAplicacionesEntity save(TrinitianosAplicacionesEntity trinitianosAplicacionesEntity);

    List<TrinitianosAplicacionesDto> findAllTrinitianosAplicacionesWithAplicaciones();

    List<TrinitianosAplicacionesDto> findAllTrinitianosAplicacionesWithAplicacionByNivel(String nivel);

    List<TrinitianosAplicacionesEntity> findByRut(String rut);

}
