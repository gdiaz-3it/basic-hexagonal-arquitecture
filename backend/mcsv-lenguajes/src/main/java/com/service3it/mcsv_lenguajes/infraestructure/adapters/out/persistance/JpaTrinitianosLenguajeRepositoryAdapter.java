package com.service3it.mcsv_lenguajes.infraestructure.adapters.out.persistance;

import java.util.List;
import java.util.stream.Collectors;

import com.service3it.mcsv_lenguajes.domain.models.TrinitianosLenguaje;
import com.service3it.mcsv_lenguajes.domain.ports.out.TrinitianosLenguajeRepositoryPort;
import com.service3it.mcsv_lenguajes.infraestructure.adapters.out.persistance.entities.TrinitianosLenguajeEntity;
import com.service3it.mcsv_lenguajes.infraestructure.adapters.out.persistance.mapper.TrinitianosLenguajesMapper;
import com.service3it.mcsv_lenguajes.infraestructure.adapters.out.persistance.repositories.TrinitianosLenguajesRepository;

public class JpaTrinitianosLenguajeRepositoryAdapter implements TrinitianosLenguajeRepositoryPort {

    private final TrinitianosLenguajesRepository trinitianosLenguajesRepository;

    public JpaTrinitianosLenguajeRepositoryAdapter(TrinitianosLenguajesRepository trinitianosLenguajesRepository) {
        this.trinitianosLenguajesRepository = trinitianosLenguajesRepository;
    }

    @Override
    public TrinitianosLenguaje getTrinitianosLenguajeById(Long id) {
        return trinitianosLenguajesRepository.findById(id)
            .map(TrinitianosLenguajesMapper::toDomain)
            .orElse(null);
    }

    @Override
    public TrinitianosLenguaje saveTrinitianosLenguaje(TrinitianosLenguaje trinitianosLenguaje) {
        TrinitianosLenguajeEntity entity = TrinitianosLenguajesMapper.toEntity(trinitianosLenguaje, null);
        TrinitianosLenguajeEntity savedEntity = trinitianosLenguajesRepository.save(entity);
        return TrinitianosLenguajesMapper.toDomain(savedEntity);
    }

    @Override
    public List<TrinitianosLenguaje> getAllTrinitianosLenguaje() {
        return trinitianosLenguajesRepository.findAll().stream()
            .map(TrinitianosLenguajesMapper::toDomain)
            .collect(Collectors.toList());
    }

    @Override
    public void deleteTrinitianosLenguajeById(Long id) {
        trinitianosLenguajesRepository.deleteById(id);
    }

    @Override
    public TrinitianosLenguaje updateTrinitianosLenguajeById(Long id, TrinitianosLenguaje trinitianosLenguaje) {
        return trinitianosLenguajesRepository.findById(id)
            .map(entity -> {
                TrinitianosLenguajesMapper.updateTrinitianosLenguajeEntityFromDomain(entity, trinitianosLenguaje);
                TrinitianosLenguajeEntity savedEntity = trinitianosLenguajesRepository.save(entity);
                return TrinitianosLenguajesMapper.toDomain(savedEntity);
            })
        .orElse(null);
    }

}
