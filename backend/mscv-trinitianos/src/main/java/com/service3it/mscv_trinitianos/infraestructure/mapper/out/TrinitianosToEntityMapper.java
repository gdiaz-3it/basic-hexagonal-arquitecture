package com.service3it.mscv_trinitianos.infraestructure.mapper.out;

import com.service3it.mscv_trinitianos.domain.models.Trinitianos;
import com.service3it.mscv_trinitianos.infraestructure.entities.TrinitianosEntity;

public class TrinitianosToEntityMapper {

    public static Trinitianos toDomainModel(TrinitianosEntity trinitianosEntity) {

        return new Trinitianos(trinitianosEntity.getId(), trinitianosEntity.getNombre(), trinitianosEntity.getApellido(), 
                               trinitianosEntity.getCorreo_electronico(), trinitianosEntity.getTelefono(),trinitianosEntity.getEstado(), 
                               trinitianosEntity.getEnlace_bizneo(), trinitianosEntity.getEnlace_hubspot(),
                               trinitianosEntity.getEnlace_jira(), trinitianosEntity.getFecha_creacion());
    }

}
