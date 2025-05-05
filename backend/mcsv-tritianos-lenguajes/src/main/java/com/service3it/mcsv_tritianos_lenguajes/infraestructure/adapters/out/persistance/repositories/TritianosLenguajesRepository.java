package com.service3it.mcsv_tritianos_lenguajes.infraestructure.adapters.out.persistance.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service3it.mcsv_tritianos_lenguajes.infraestructure.adapters.out.persistance.entities.TritianosLenguajeEntity;

public interface TritianosLenguajesRepository extends JpaRepository<TritianosLenguajeEntity, Long> {

    List<TritianosLenguajeEntity> findByRut(String rut);

}
