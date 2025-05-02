package com.service3it.mscv_tritianos.infraestructure.adapters.out.persistance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service3it.mscv_tritianos.infraestructure.adapters.out.persistance.entities.TritianosEntity;

public interface TritianosRepository extends JpaRepository<TritianosEntity, Long> {

}
