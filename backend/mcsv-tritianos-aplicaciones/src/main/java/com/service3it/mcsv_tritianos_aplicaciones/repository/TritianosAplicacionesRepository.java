package com.service3it.mcsv_tritianos_aplicaciones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service3it.mcsv_tritianos_aplicaciones.model.TritianosAplicacionesEntity;


public interface TritianosAplicacionesRepository extends JpaRepository<TritianosAplicacionesEntity, Long> {

    List<TritianosAplicacionesEntity> findByClienteId(Long clienteId);

}
