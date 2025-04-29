package com.service3it.mcsv_lenguajes.application.usecase;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service3it.mcsv_lenguajes.domain.ports.in.DeleteTrinitianosLenguajeByIdUseCase;
import com.service3it.mcsv_lenguajes.domain.ports.out.TrinitianosLenguajeRepositoryPort;

@Service
public class DeleteTrinitianosLenguajeByIdUseCaseImpl implements DeleteTrinitianosLenguajeByIdUseCase {

    private final TrinitianosLenguajeRepositoryPort trinitianosLenguajeRepositoryPort;

    public DeleteTrinitianosLenguajeByIdUseCaseImpl(TrinitianosLenguajeRepositoryPort trinitianosLenguajeRepositoryPort) {
        this.trinitianosLenguajeRepositoryPort = trinitianosLenguajeRepositoryPort;
    }

    @Override
    @Transactional
    public void deleteTrinitianosLenguajeById(Long id) {
        trinitianosLenguajeRepositoryPort.deleteTrinitianosLenguajeById(id);
    }
 
}
