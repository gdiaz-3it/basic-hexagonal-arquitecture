package com.service3it.mscv_trinitianos.infraestructure.adapters.out.persistance.mapper;

import com.service3it.mscv_trinitianos.domain.models.Trinitianos;
import com.service3it.mscv_trinitianos.infraestructure.adapters.out.persistance.entities.TrinitianosEntity;

public class TrinitianosMapper {

    public static TrinitianosEntity toEntity(Trinitianos trinitianos) {
        return new TrinitianosEntity(
            trinitianos.getId(),
            trinitianos.getNombre(),
            trinitianos.getApellido(),
            trinitianos.getCorreoElectronico(),
            trinitianos.getTelefono(),
            trinitianos.getEstado(),
            trinitianos.getEnlaceBizneo(),
            trinitianos.getEnlaceHubspot(),
            trinitianos.getEnlaceJira(),
            trinitianos.getFechaCreacion(),
            trinitianos.getFechaModificacion()
        );
    }

    public static Trinitianos toDomain(TrinitianosEntity trinitianosEntity) {
        return new Trinitianos(
            trinitianosEntity.getId(),
            trinitianosEntity.getNombre(),
            trinitianosEntity.getApellido(),
            trinitianosEntity.getCorreoElectronico(),
            trinitianosEntity.getTelefono(),
            trinitianosEntity.getEstado(),
            trinitianosEntity.getEnlaceBizneo(),
            trinitianosEntity.getEnlaceHubspot(),
            trinitianosEntity.getEnlaceJira(),
            trinitianosEntity.getFechaCreacion(),
            trinitianosEntity.getFechaModificacion()
        );
    }

    public static void updateEntityFromDomain(TrinitianosEntity trinitianosEntity, Trinitianos trinitianos) {
        if (trinitianos.getNombre() != null) {
            trinitianosEntity.setNombre(trinitianos.getNombre());
        }
        if (trinitianos.getApellido() != null) {
            trinitianosEntity.setApellido(trinitianos.getApellido());
        }
        if (trinitianos.getCorreoElectronico() != null) {
            trinitianosEntity.setCorreoElectronico(trinitianos.getCorreoElectronico());
        }
        if (trinitianos.getTelefono() != null) {
            trinitianosEntity.setTelefono(trinitianos.getTelefono());
        }
        if (trinitianos.getEstado() != null) {
            trinitianosEntity.setEstado(trinitianos.getEstado());
        }
        if (trinitianos.getEnlaceBizneo() != null) {
            trinitianosEntity.setEnlaceBizneo(trinitianos.getEnlaceBizneo());
        }
        if (trinitianos.getEnlaceHubspot() != null) {
            trinitianosEntity.setEnlaceHubspot(trinitianos.getEnlaceHubspot());
        }
        if (trinitianos.getEnlaceJira() != null) {
            trinitianosEntity.setEnlaceJira(trinitianos.getEnlaceJira());
        }
    }

}
