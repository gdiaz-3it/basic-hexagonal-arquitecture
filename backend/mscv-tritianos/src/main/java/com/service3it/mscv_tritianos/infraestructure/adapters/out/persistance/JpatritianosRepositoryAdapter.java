package com.service3it.mscv_tritianos.infraestructure.adapters.out.persistance;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.service3it.mscv_tritianos.domain.models.Tritianos;
import com.service3it.mscv_tritianos.domain.ports.out.TritianosRepositoryPort;
import com.service3it.mscv_tritianos.infraestructure.adapters.out.persistance.entities.TritianosEntity;
import com.service3it.mscv_tritianos.infraestructure.adapters.out.persistance.mapper.TritianosMapper;
import com.service3it.mscv_tritianos.infraestructure.adapters.out.persistance.repositories.TritianosRepository;

@Component
public class JpatritianosRepositoryAdapter implements TritianosRepositoryPort {

    private final TritianosRepository tritianosRepository;

    public JpatritianosRepositoryAdapter(TritianosRepository tritianosRepository) {
        this.tritianosRepository = tritianosRepository;
    }

    @Override
    public Tritianos getTritianosById(Long id) {
        return tritianosRepository.findById(id)
            .map(TritianosMapper::toDomain).
            orElse(null);
    }

    @Override
    public Tritianos saveTritianos(Tritianos tritianos) {
        TritianosEntity tritianosEntity = TritianosMapper.toEntity(tritianos);
        TritianosEntity savedEntity = tritianosRepository.save(tritianosEntity);
        return TritianosMapper.toDomain(savedEntity);
    }

    @Override
    public List<Tritianos> getAllTritianos() {
        return tritianosRepository.findAll().stream()
            .map(TritianosMapper::toDomain)
            .collect(Collectors.toList());
    }

    @Override
    public void deleteTritianoById(Long id) {
        tritianosRepository.deleteById(id);
    }

    @Override
    public Tritianos updateTritianoById(Long id, Tritianos tritianos) {
        return tritianosRepository.findById(id)
            .map(existingEntity -> {
                TritianosMapper.updateEntityFromDomain(existingEntity, tritianos);
                TritianosEntity savedEntity = tritianosRepository.save(existingEntity);
                return TritianosMapper.toDomain(savedEntity);
            })
        .orElse(null);
    }

}
