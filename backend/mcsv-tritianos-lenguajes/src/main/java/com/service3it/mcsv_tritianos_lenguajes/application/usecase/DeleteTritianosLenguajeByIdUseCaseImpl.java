package com.service3it.mcsv_tritianos_lenguajes.application.usecase;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service3it.mcsv_tritianos_lenguajes.domain.ports.in.DeleteTritianosLenguajeByIdUseCase;
import com.service3it.mcsv_tritianos_lenguajes.domain.ports.out.TritianosLenguajeRepositoryPort;


@Service
public class DeleteTritianosLenguajeByIdUseCaseImpl implements DeleteTritianosLenguajeByIdUseCase {

    private final TritianosLenguajeRepositoryPort tritianosLenguajeRepositoryPort;

    public DeleteTritianosLenguajeByIdUseCaseImpl(TritianosLenguajeRepositoryPort tritianosLenguajeRepositoryPort) {
        this.tritianosLenguajeRepositoryPort = tritianosLenguajeRepositoryPort;
    }

    @Override
    @Transactional
    public void deleteTritianosLenguajeById(Long id) {
        tritianosLenguajeRepositoryPort.deleteTritianosLenguajeById(id);
    }
 
}
