package com.service3it.mscv_trinitianos.infraestructure.mapper.in;

import com.service3it.mscv_trinitianos.domain.models.Trinitianos;
import com.service3it.mscv_trinitianos.infraestructure.entities.TrinitianosEntity;

public class TrinitianosUpdateMapper {

    public static void updateEntityFromDomain(TrinitianosEntity trinitianosEntity, Trinitianos trinitianos) {
        if (trinitianos.getNombre() != null) {
            trinitianosEntity.setNombre(trinitianos.getNombre());
        }
        if (trinitianos.getApellido() != null) {
            trinitianosEntity.setApellido(trinitianos.getApellido());
        }
        if (trinitianos.getCorreo_electronico() != null) {
            trinitianosEntity.setCorreo_electronico(trinitianos.getCorreo_electronico());
        }
        if (trinitianos.getTelefono() != null) {
            trinitianosEntity.setTelefono(trinitianos.getTelefono());
        }
        if (trinitianos.getEstado() != null) {
            trinitianosEntity.setEstado(trinitianos.getEstado());
        }
        if (trinitianos.getEnlace_bizneo() != null) {
            trinitianosEntity.setEnlace_bizneo(trinitianos.getEnlace_bizneo());
        }
        if (trinitianos.getEnlace_hubspot() != null) {
            trinitianosEntity.setEnlace_hubspot(trinitianos.getEnlace_hubspot());
        }
        if (trinitianos.getEnlace_jira() != null) {
            trinitianosEntity.setEnlace_jira(trinitianos.getEnlace_jira());
        }
    }
}
