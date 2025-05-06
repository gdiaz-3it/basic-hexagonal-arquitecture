package com.service3it.mcsv_tritianos_aplicaciones.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service3it.mcsv_tritianos_aplicaciones.model.TritianosAplicacionesEntity;
import com.service3it.mcsv_tritianos_aplicaciones.repository.TritianosAplicacionesRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TritianosAplicacionesServiceImpl implements TritianosAplicacionesService {

    private final TritianosAplicacionesRepository tritianosAplicacionesRepository;

    public TritianosAplicacionesServiceImpl(TritianosAplicacionesRepository tritianosAplicacionesRepository) {
        this.tritianosAplicacionesRepository = tritianosAplicacionesRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<TritianosAplicacionesEntity> findAll() {
        return tritianosAplicacionesRepository.findAll();
    }

    @Override
    @Transactional
    public TritianosAplicacionesEntity save(TritianosAplicacionesEntity tritianosAplicacionesEntity) {
        return tritianosAplicacionesRepository.save(tritianosAplicacionesEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TritianosAplicacionesEntity> getAplicacionesByClienteId(Long clienteId) {
        return tritianosAplicacionesRepository.findByClienteId(clienteId);
    }

}
