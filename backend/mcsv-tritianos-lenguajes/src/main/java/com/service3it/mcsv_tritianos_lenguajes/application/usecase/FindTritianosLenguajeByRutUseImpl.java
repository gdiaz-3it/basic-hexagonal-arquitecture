package com.service3it.mcsv_tritianos_lenguajes.application.usecase;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service3it.mcsv_tritianos_lenguajes.domain.models.TritianosLenguaje;
import com.service3it.mcsv_tritianos_lenguajes.domain.ports.in.FindTritianosLenguajeByRutUseCase;
import com.service3it.mcsv_tritianos_lenguajes.domain.ports.out.TritianosLenguajeRepositoryPort;

@Service
public class FindTritianosLenguajeByRutUseImpl implements FindTritianosLenguajeByRutUseCase {

    private final TritianosLenguajeRepositoryPort tritianosLenguajeRepositoryPort;

    public FindTritianosLenguajeByRutUseImpl(TritianosLenguajeRepositoryPort tritianosLenguajeRepositoryPort) {
        this.tritianosLenguajeRepositoryPort = tritianosLenguajeRepositoryPort;
    }

    @Override
    @Transactional(readOnly = true)
    public List<TritianosLenguaje> findTritianosLenguajesByRut(String rut) {
        return tritianosLenguajeRepositoryPort.findTritianosLenguajesByRut(rut);
    }



}
