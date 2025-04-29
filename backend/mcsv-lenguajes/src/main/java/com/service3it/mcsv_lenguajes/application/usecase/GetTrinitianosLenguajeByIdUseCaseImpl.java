package com.service3it.mcsv_lenguajes.application.usecase;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service3it.mcsv_lenguajes.domain.models.TrinitianosLenguaje;
import com.service3it.mcsv_lenguajes.domain.ports.in.GetTrinitianosLenguajeByIdUseCase;
import com.service3it.mcsv_lenguajes.domain.ports.out.TrinitianosLenguajeRepositoryPort;

@Service
public class GetTrinitianosLenguajeByIdUseCaseImpl implements GetTrinitianosLenguajeByIdUseCase {

    private final TrinitianosLenguajeRepositoryPort trinitianosLenguajeRepositoryPort;

    public GetTrinitianosLenguajeByIdUseCaseImpl(TrinitianosLenguajeRepositoryPort trinitianosLenguajeRepositoryPort) {
        this.trinitianosLenguajeRepositoryPort = trinitianosLenguajeRepositoryPort;
    }

    @Override
    @Transactional(readOnly = true)
    public TrinitianosLenguaje getTrinitianosLenguajeById(Long id) {
        return trinitianosLenguajeRepositoryPort.getTrinitianosLenguajeById(id);
    }

}
