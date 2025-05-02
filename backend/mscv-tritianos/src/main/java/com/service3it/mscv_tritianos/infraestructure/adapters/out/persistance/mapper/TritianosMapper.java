package com.service3it.mscv_tritianos.infraestructure.adapters.out.persistance.mapper;

import com.service3it.mscv_tritianos.domain.models.Tritianos;
import com.service3it.mscv_tritianos.infraestructure.adapters.out.persistance.entities.TritianosEntity;

public class TritianosMapper {

    public static TritianosEntity toEntity(Tritianos tritianos) {
        return new TritianosEntity(
            tritianos.getId(),
            tritianos.getNombre(),
            tritianos.getApellido(),
            tritianos.getCorreoElectronico(),
            tritianos.getRut(),
            tritianos.getTelefono(),
            tritianos.getEstado(),
            tritianos.getEnlaceBizneo(),
            tritianos.getEnlaceHubspot(),
            tritianos.getEnlaceJira(),
            tritianos.getFechaCreacion(),
            tritianos.getFechaModificacion()
        );
    }

    public static Tritianos toDomain(TritianosEntity tritianosEntity) {
        return new Tritianos(
            tritianosEntity.getId(),
            tritianosEntity.getNombre(),
            tritianosEntity.getApellido(),
            tritianosEntity.getCorreoElectronico(),
            tritianosEntity.getRut(),
            tritianosEntity.getTelefono(),
            tritianosEntity.getEstado(),
            tritianosEntity.getEnlaceBizneo(),
            tritianosEntity.getEnlaceHubspot(),
            tritianosEntity.getEnlaceJira(),
            tritianosEntity.getFechaCreacion(),
            tritianosEntity.getFechaModificacion()
        );
    }

    public static void updateEntityFromDomain(TritianosEntity tritianosEntity, Tritianos tritianos) {
        if (tritianos.getNombre() != null) {
            tritianosEntity.setNombre(tritianos.getNombre());
        }
        if (tritianos.getApellido() != null) {
            tritianosEntity.setApellido(tritianos.getApellido());
        }
        if (tritianos.getCorreoElectronico() != null) {
            tritianosEntity.setCorreoElectronico(tritianos.getCorreoElectronico());
        }
        if (tritianos.getRut() != null) {
            tritianosEntity.setRut(tritianos.getRut());
        }
        if (tritianos.getTelefono() != null) {
            tritianosEntity.setTelefono(tritianos.getTelefono());
        }
        if (tritianos.getEstado() != null) {
            tritianosEntity.setEstado(tritianos.getEstado());
        }
        if (tritianos.getEnlaceBizneo() != null) {
            tritianosEntity.setEnlaceBizneo(tritianos.getEnlaceBizneo());
        }
        if (tritianos.getEnlaceHubspot() != null) {
            tritianosEntity.setEnlaceHubspot(tritianos.getEnlaceHubspot());
        }
        if (tritianos.getEnlaceJira() != null) {
            tritianosEntity.setEnlaceJira(tritianos.getEnlaceJira());
        }
    }

}
