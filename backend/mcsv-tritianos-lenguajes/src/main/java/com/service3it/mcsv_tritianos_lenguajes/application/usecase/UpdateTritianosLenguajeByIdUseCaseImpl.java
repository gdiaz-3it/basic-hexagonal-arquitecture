package com.service3it.mcsv_tritianos_lenguajes.application.usecase;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service3it.mcsv_tritianos_lenguajes.domain.models.TritianosLenguaje;
import com.service3it.mcsv_tritianos_lenguajes.domain.ports.in.UpdateTritianosLenguajeByIdUseCase;
import com.service3it.mcsv_tritianos_lenguajes.domain.ports.out.TritianosLenguajeRepositoryPort;


@Service
public class UpdateTritianosLenguajeByIdUseCaseImpl implements UpdateTritianosLenguajeByIdUseCase {

    private final TritianosLenguajeRepositoryPort tritianosLenguajeRepositoryPort;

    public UpdateTritianosLenguajeByIdUseCaseImpl(TritianosLenguajeRepositoryPort tritianosLenguajeRepositoryPort) {
        this.tritianosLenguajeRepositoryPort = tritianosLenguajeRepositoryPort;
    }

    @Override
    @Transactional
    public TritianosLenguaje updateTritianosLenguajeById(Long id, TritianosLenguaje tritianosLenguaje) {
        return tritianosLenguajeRepositoryPort.updateTritianosLenguajeById(id, tritianosLenguaje);
    }

}
