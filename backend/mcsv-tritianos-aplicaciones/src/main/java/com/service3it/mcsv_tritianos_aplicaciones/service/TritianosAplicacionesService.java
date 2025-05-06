package com.service3it.mcsv_tritianos_aplicaciones.service;

import java.util.List;

import com.service3it.mcsv_tritianos_aplicaciones.model.TritianosAplicacionesEntity;


public interface TritianosAplicacionesService {

    Iterable<TritianosAplicacionesEntity> findAll();

    TritianosAplicacionesEntity save(TritianosAplicacionesEntity tritianosAplicacionesEntity);

    List<TritianosAplicacionesEntity> getAplicacionesByClienteId(Long clienteId);

}
