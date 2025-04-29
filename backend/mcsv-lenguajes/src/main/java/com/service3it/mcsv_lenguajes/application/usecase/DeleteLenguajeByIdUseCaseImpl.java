package com.service3it.mcsv_lenguajes.application.usecase;

import org.springframework.transaction.annotation.Transactional;

import com.service3it.mcsv_lenguajes.domain.ports.in.DeleteLenguajeByIdUseCase;
import com.service3it.mcsv_lenguajes.domain.ports.out.LenguajesRepositoryPort;

public class DeleteLenguajeByIdUseCaseImpl implements DeleteLenguajeByIdUseCase {

    private final LenguajesRepositoryPort lenguajesRepositoryPort;

    public DeleteLenguajeByIdUseCaseImpl(LenguajesRepositoryPort lenguajesRepositoryPort) {
        this.lenguajesRepositoryPort = lenguajesRepositoryPort;
    }

    @Override
    @Transactional
    public void deleteLenguajeById(Long id) {
        lenguajesRepositoryPort.deleteLenguajesById(id);
    }

}
