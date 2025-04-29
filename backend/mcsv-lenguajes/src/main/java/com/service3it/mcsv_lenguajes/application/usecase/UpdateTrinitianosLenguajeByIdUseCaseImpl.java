package com.service3it.mcsv_lenguajes.application.usecase;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service3it.mcsv_lenguajes.domain.models.TrinitianosLenguaje;
import com.service3it.mcsv_lenguajes.domain.ports.in.UpdateTrinitianosLenguajeByIdUseCase;
import com.service3it.mcsv_lenguajes.domain.ports.out.TrinitianosLenguajeRepositoryPort;

@Service
public class UpdateTrinitianosLenguajeByIdUseCaseImpl implements UpdateTrinitianosLenguajeByIdUseCase {

    private final TrinitianosLenguajeRepositoryPort trinitianosLenguajeRepositoryPort;

    public UpdateTrinitianosLenguajeByIdUseCaseImpl(TrinitianosLenguajeRepositoryPort trinitianosLenguajeRepositoryPort) {
        this.trinitianosLenguajeRepositoryPort = trinitianosLenguajeRepositoryPort;
    }

    @Override
    @Transactional
    public TrinitianosLenguaje updateTrinitianosLenguajeById(Long id, TrinitianosLenguaje trinitianosLenguaje) {
        return trinitianosLenguajeRepositoryPort.updateTrinitianosLenguajeById(id, trinitianosLenguaje);
    }

}
