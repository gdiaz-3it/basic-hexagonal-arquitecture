package com.service3it.mcsv_trinitianos_aplicaciones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service3it.mcsv_trinitianos_aplicaciones.model.TrinitianosAplicacionesEntity;

public interface TrinitianosAplicacionesRepository extends JpaRepository<TrinitianosAplicacionesEntity, Long> {

    List<TrinitianosAplicacionesEntity> findByNivel(String nivel);

    List<TrinitianosAplicacionesEntity> findByRut(String rut);

}
