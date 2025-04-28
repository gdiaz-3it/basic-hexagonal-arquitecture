package com.service3it.mcsv_lenguajes.infraestructure.adapters.out.persistance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service3it.mcsv_lenguajes.infraestructure.adapters.out.persistance.entities.LenguajesEntity;

public interface LenguajesRepository extends JpaRepository<LenguajesEntity, Long> {

}
