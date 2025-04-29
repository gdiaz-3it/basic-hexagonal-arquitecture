package com.service3it.mcsv_lenguajes.infraestructure.adapters.out.persistance;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.service3it.mcsv_lenguajes.domain.models.Lenguajes;
import com.service3it.mcsv_lenguajes.domain.ports.out.LenguajesRepositoryPort;
import com.service3it.mcsv_lenguajes.infraestructure.adapters.out.persistance.entities.LenguajesEntity;
import com.service3it.mcsv_lenguajes.infraestructure.adapters.out.persistance.mapper.LenguajesMapper;
import com.service3it.mcsv_lenguajes.infraestructure.adapters.out.persistance.repositories.LenguajesRepository;

@Component
public class JpaLenguajesRepositoryAdapter implements LenguajesRepositoryPort {

    private final LenguajesRepository lenguajesRepository;

    public JpaLenguajesRepositoryAdapter(LenguajesRepository lenguajesRepository) {
        this.lenguajesRepository = lenguajesRepository;
    }

    @Override
    public Lenguajes getLenguajesById(Long id) {
        return lenguajesRepository.findById(id)
            .map(LenguajesMapper::toDomain)
            .orElse(null);
    }

    @Override
    public Lenguajes saveLenguajes(Lenguajes lenguajes) {
        LenguajesEntity lenguajesEntity = LenguajesMapper.toEntity(lenguajes);
        LenguajesEntity savedEntity = lenguajesRepository.save(lenguajesEntity);
        return LenguajesMapper.toDomain(savedEntity);
    }

    @Override
    public List<Lenguajes> getAllLenguajes() {
        return lenguajesRepository.findAll().stream()
            .map(LenguajesMapper::toDomain)
            .collect(Collectors.toList());
    }
    
    @Override
    public void deleteLenguajesById(Long id) {
        lenguajesRepository.deleteById(id);
    }

    @Override
    public Lenguajes updateLenguajesById(Long id, Lenguajes lenguajes) {
        return lenguajesRepository.findById(id)
            .map(lenguajesEntity -> {
                LenguajesMapper.updateEntityFromDomain(lenguajesEntity, lenguajes);
                LenguajesEntity savedEntity = lenguajesRepository.save(lenguajesEntity);
                return LenguajesMapper.toDomain(savedEntity);
            })
        .orElse(null);
    }
}
