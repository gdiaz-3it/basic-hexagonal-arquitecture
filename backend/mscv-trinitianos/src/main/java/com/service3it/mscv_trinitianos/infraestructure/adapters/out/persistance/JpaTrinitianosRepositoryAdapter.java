package com.service3it.mscv_trinitianos.infraestructure.adapters.out.persistance;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.service3it.mscv_trinitianos.domain.models.Trinitianos;
import com.service3it.mscv_trinitianos.domain.ports.out.TrinitianosRepositoryPort;
import com.service3it.mscv_trinitianos.infraestructure.adapters.out.persistance.entities.TrinitianosEntity;
import com.service3it.mscv_trinitianos.infraestructure.adapters.out.persistance.mapper.TrinitianosMapper;
import com.service3it.mscv_trinitianos.infraestructure.adapters.out.persistance.repositories.TrinitianosRepository;

@Component
public class JpaTrinitianosRepositoryAdapter implements TrinitianosRepositoryPort {

    private final TrinitianosRepository trinitianosRepository;

    public JpaTrinitianosRepositoryAdapter(TrinitianosRepository trinitianosRepository) {
        this.trinitianosRepository = trinitianosRepository;
    }

    @Override
    public Trinitianos getTrinitianosById(Long id) {
        return trinitianosRepository.findById(id)
            .map(TrinitianosMapper::toDomain).
            orElse(null);
    }

    @Override
    public Trinitianos saveTrinitianos(Trinitianos trinitianos) {
        TrinitianosEntity trinitianosEntity = TrinitianosMapper.toEntity(trinitianos);
        TrinitianosEntity savedEntity = trinitianosRepository.save(trinitianosEntity);
        return TrinitianosMapper.toDomain(savedEntity);
    }

    @Override
    public List<Trinitianos> getAllTrinitianos() {
        return trinitianosRepository.findAll().stream()
            .map(TrinitianosMapper::toDomain)
            .collect(Collectors.toList());
    }

    @Override
    public void deleteTrinitianoById(Long id) {
        trinitianosRepository.deleteById(id);
    }

    @Override
    public Trinitianos updateTrinitianoById(Long id, Trinitianos trinitianos) {
        return trinitianosRepository.findById(id)
            .map(existingEntity -> {
                TrinitianosMapper.updateEntityFromDomain(existingEntity, trinitianos);
                TrinitianosEntity savedEntity = trinitianosRepository.save(existingEntity);
                return TrinitianosMapper.toDomain(savedEntity);
            })
        .orElse(null);
    }

}
