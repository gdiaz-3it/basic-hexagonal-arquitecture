package com.service3it.mscv_trinitianos.infraestructure.adapters.out.persistance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service3it.mscv_trinitianos.infraestructure.adapters.out.persistance.entities.TrinitianosEntity;

public interface TrinitianosRepository extends JpaRepository<TrinitianosEntity, Long> {

}
