package com.service3it.mcsv_aplicaciones.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service3it.mcsv_aplicaciones.model.AplicacionesEntity;
import com.service3it.mcsv_aplicaciones.repository.AplicacionesRepository;

@Service
public class AplicacionesServiceImpl implements AplicacionesService {

    private final AplicacionesRepository aplicacionesRepository;

    public AplicacionesServiceImpl(AplicacionesRepository aplicacionesRepository) {
        this.aplicacionesRepository = aplicacionesRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<AplicacionesEntity> findAll() {
        return aplicacionesRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<AplicacionesEntity> findByNivel(String nivel) {
        if (nivel == null || nivel.trim().isEmpty()) {
            throw new IllegalArgumentException("El nivel no puede ser nulo o vacío");
        }
        return aplicacionesRepository.findByNivel(nivel);
    }

    @Override
    @Transactional
    public AplicacionesEntity save(AplicacionesEntity aplicacionesEntity) {
        return aplicacionesRepository.save(aplicacionesEntity);
    }

}
