package com.service3it.mcsv_tritianos_lenguajes.infraestructure.adapters.out.persistance;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.service3it.mcsv_tritianos_lenguajes.domain.models.TritianosLenguaje;
import com.service3it.mcsv_tritianos_lenguajes.domain.ports.out.TritianosLenguajeRepositoryPort;
import com.service3it.mcsv_tritianos_lenguajes.infraestructure.adapters.out.persistance.entities.TritianosLenguajeEntity;
import com.service3it.mcsv_tritianos_lenguajes.infraestructure.adapters.out.persistance.mapper.TritianosLenguajesMapper;
import com.service3it.mcsv_tritianos_lenguajes.infraestructure.adapters.out.persistance.repositories.TritianosLenguajesRepository;


@Component
public class JpaTritianosLenguajeRepositoryAdapter implements TritianosLenguajeRepositoryPort {

    private final TritianosLenguajesRepository tritianosLenguajesRepository;

    public JpaTritianosLenguajeRepositoryAdapter(TritianosLenguajesRepository tritianosLenguajesRepository) {
        this.tritianosLenguajesRepository = tritianosLenguajesRepository;
    }

    @Override
    public TritianosLenguaje getTritianosLenguajeById(Long id) {
        return tritianosLenguajesRepository.findById(id)
            .map(TritianosLenguajesMapper::toDomain)
            .orElse(null);
    }

    @Override
    public TritianosLenguaje saveTritianosLenguaje(TritianosLenguaje tritianosLenguaje) {
        TritianosLenguajeEntity entity = TritianosLenguajesMapper.toEntity(tritianosLenguaje);
        TritianosLenguajeEntity savedEntity = tritianosLenguajesRepository.save(entity);
        return TritianosLenguajesMapper.toDomain(savedEntity);
    }

    @Override
    public List<TritianosLenguaje> getAllTritianosLenguaje() {
        return tritianosLenguajesRepository.findAll().stream()
            .map(TritianosLenguajesMapper::toDomain)
            .collect(Collectors.toList());
    }

    @Override
    public void deleteTritianosLenguajeById(Long id) {
        tritianosLenguajesRepository.deleteById(id);
    }

    @Override
    public TritianosLenguaje updateTritianosLenguajeById(Long id, TritianosLenguaje tritianosLenguaje) {
        return tritianosLenguajesRepository.findById(id)
            .map(entity -> {
                TritianosLenguajesMapper.updateTritianosLenguajeEntityFromDomain(entity, tritianosLenguaje);
                TritianosLenguajeEntity savedEntity = tritianosLenguajesRepository.save(entity);
                return TritianosLenguajesMapper.toDomain(savedEntity);
            })
        .orElse(null);
    }

}
