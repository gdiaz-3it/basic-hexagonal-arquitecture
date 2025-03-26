package com.service3it.mscv_trinitianos.infraestructure.adapters;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.service3it.mscv_trinitianos.domain.models.Trinitianos;
import com.service3it.mscv_trinitianos.domain.ports.out.TrinitianosRepositoryPort;
import com.service3it.mscv_trinitianos.infraestructure.entities.TrinitianosEntity;
import com.service3it.mscv_trinitianos.infraestructure.mapper.in.TrinitianosDomainToEntityMapper;
import com.service3it.mscv_trinitianos.infraestructure.mapper.in.TrinitianosUpdateMapper;
import com.service3it.mscv_trinitianos.infraestructure.mapper.out.TrinitianosEntityToDomainMapper;
import com.service3it.mscv_trinitianos.infraestructure.repositories.TrinitianosRepository;

@Component
public class JpaTrinitianosRepositoryAdapter implements TrinitianosRepositoryPort {

    private final TrinitianosRepository trinitianosRepository;

    public JpaTrinitianosRepositoryAdapter(TrinitianosRepository trinitianosRepository) {
        this.trinitianosRepository = trinitianosRepository;
    }

    @Override
    public Trinitianos getTrinitianosById(Long id) {
        return trinitianosRepository.findById(id)
            .map(TrinitianosEntityToDomainMapper::toDomain).
            orElse(null);
    }

    @Override
    public Trinitianos saveTrinitianos(Trinitianos trinitianos) {
        TrinitianosEntity trinitianosEntity = TrinitianosDomainToEntityMapper.toEntity(trinitianos);
        TrinitianosEntity savedEntity = trinitianosRepository.save(trinitianosEntity);
        return TrinitianosEntityToDomainMapper.toDomain(savedEntity);
    }

    @Override
    public List<Trinitianos> getAllTrinitianos() {
        return trinitianosRepository.findAll().stream()
            .map(TrinitianosEntityToDomainMapper::toDomain)
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
                TrinitianosUpdateMapper.updateEntityFromDomain(existingEntity, trinitianos);
                TrinitianosEntity savedEntity = trinitianosRepository.save(existingEntity);
                return TrinitianosEntityToDomainMapper.toDomain(savedEntity);
            })
        .orElse(null);
    }

}
