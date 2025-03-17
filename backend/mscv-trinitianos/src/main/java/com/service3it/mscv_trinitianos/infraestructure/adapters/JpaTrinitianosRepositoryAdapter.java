package com.service3it.mscv_trinitianos.infraestructure.adapters;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.service3it.mscv_trinitianos.domain.models.Trinitianos;
import com.service3it.mscv_trinitianos.domain.ports.out.TrinitianosRepositoryPort;
import com.service3it.mscv_trinitianos.infraestructure.entities.TrinitianosEntity;
import com.service3it.mscv_trinitianos.infraestructure.repositories.TrinitianosRepository;

@Component
public class JpaTrinitianosRepositoryAdapter implements TrinitianosRepositoryPort {

    private final TrinitianosRepository trinitianosRepository;

    public JpaTrinitianosRepositoryAdapter(TrinitianosRepository trinitianosRepository) {
        this.trinitianosRepository = trinitianosRepository;
    }

    @Override
    public Trinitianos getTrinitianosById(Long id) {
        return trinitianosRepository.findById(id).map(TrinitianosEntity::toDomainModel).orElse(null);
    }

    @Override
    public Trinitianos saveTrinitianos(Trinitianos trinitianos) {
        TrinitianosEntity trinitianosEntity = TrinitianosEntity.fromDomainModel(trinitianos);
        trinitianosRepository.save(trinitianosEntity);
        return trinitianosEntity.toDomainModel();
    }

    @Override
    public List<Trinitianos> getAllTrinitianos() {
        return trinitianosRepository.findAll().stream().map(TrinitianosEntity::toDomainModel).collect(Collectors.toList());
    }

    @Override
    public void deleteTrinitianoById(Long id) {
        trinitianosRepository.deleteById(id);
    }

    @Override
    public Trinitianos updateTrinitianoById(Long id, Trinitianos trinitianos) {
        return trinitianosRepository.findById(id)
            .map(existingEntity -> {
                if (trinitianos.getNombre() != null) {
                    existingEntity.setNombre(trinitianos.getNombre());
                }
                if (trinitianos.getApellido() != null) {
                    existingEntity.setApellido(trinitianos.getApellido());
                }
                if (trinitianos.getCorreo_electronico() != null) {
                    existingEntity.setCorreo_electronico(trinitianos.getCorreo_electronico());
                }   
                if (trinitianos.getTelefono() != null) {
                    existingEntity.setTelefono(trinitianos.getTelefono());
                }
                if (trinitianos.getEstado() != null) {
                    existingEntity.setEstado(trinitianos.getEstado());
                }
                if (trinitianos.getEnlace_bizneo() != null) {
                    existingEntity.setEnlace_bizneo(trinitianos.getEnlace_bizneo());
                }
                if (trinitianos.getEnlace_hubspot() != null) {
                    existingEntity.setEnlace_hubspot(trinitianos.getEnlace_hubspot());
                }
                if (trinitianos.getEnlace_jira() != null) {
                    existingEntity.setEnlace_jira(trinitianos.getEnlace_jira());
                }
                trinitianosRepository.save(existingEntity);
                return existingEntity.toDomainModel();
            })
        .orElse(null); // Si no encuentra la entidad, devuelve null
    }

}
