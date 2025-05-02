package com.service3it.mcsv_aplicaciones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service3it.mcsv_aplicaciones.model.AplicacionesEntity;

public interface AplicacionesRepository extends JpaRepository<AplicacionesEntity, Long> {

    List<AplicacionesEntity> findByNivel(String nivel);
}
