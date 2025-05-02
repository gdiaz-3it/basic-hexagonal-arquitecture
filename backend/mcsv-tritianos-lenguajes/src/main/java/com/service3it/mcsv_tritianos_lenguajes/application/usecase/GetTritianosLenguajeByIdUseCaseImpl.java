package com.service3it.mcsv_tritianos_lenguajes.application.usecase;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service3it.mcsv_tritianos_lenguajes.domain.models.TritianosLenguaje;
import com.service3it.mcsv_tritianos_lenguajes.domain.ports.in.GetTritianosLenguajeByIdUseCase;
import com.service3it.mcsv_tritianos_lenguajes.domain.ports.out.TritianosLenguajeRepositoryPort;


@Service
public class GetTritianosLenguajeByIdUseCaseImpl implements GetTritianosLenguajeByIdUseCase {

    private final TritianosLenguajeRepositoryPort tritianosLenguajeRepositoryPort;

    public GetTritianosLenguajeByIdUseCaseImpl(TritianosLenguajeRepositoryPort tritianosLenguajeRepositoryPort) {
        this.tritianosLenguajeRepositoryPort = tritianosLenguajeRepositoryPort;
    }

    @Override
    @Transactional(readOnly = true)
    public TritianosLenguaje getTritianosLenguajeById(Long id) {
        return tritianosLenguajeRepositoryPort.getTritianosLenguajeById(id);
    }

}
