package com.service3it.mcsv_aplicaciones.service;

import java.util.List;

import com.service3it.mcsv_aplicaciones.model.AplicacionesEntity;

public interface AplicacionesService {

    Iterable<AplicacionesEntity> findAll();

    List<AplicacionesEntity> findByNivel(String nivel);

    AplicacionesEntity save(AplicacionesEntity aplicacionesEntity);

}
