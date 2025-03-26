package com.service3it.mscv_trinitianos.infraestructure.mapper.in;

import com.service3it.mscv_trinitianos.domain.models.Trinitianos;
import com.service3it.mscv_trinitianos.infraestructure.entities.TrinitianosEntity;

public class TrinitianosDomainToEntityMapper {

    public static TrinitianosEntity toEntity(Trinitianos trinitianos) {

        return new TrinitianosEntity(trinitianos.getId(), trinitianos.getNombre(), trinitianos.getApellido(),
                                    trinitianos.getCorreo_electronico(), trinitianos.getTelefono(), trinitianos.getEstado(),
                                    trinitianos.getEnlace_bizneo(), trinitianos.getEnlace_hubspot(), trinitianos.getEnlace_jira(), 
                                    trinitianos.getFecha_creacion());
    }
}
