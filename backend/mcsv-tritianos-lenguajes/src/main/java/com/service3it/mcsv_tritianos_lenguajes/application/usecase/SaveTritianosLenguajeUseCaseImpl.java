package com.service3it.mcsv_tritianos_lenguajes.application.usecase;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service3it.mcsv_tritianos_lenguajes.domain.models.TritianosLenguaje;
import com.service3it.mcsv_tritianos_lenguajes.domain.ports.in.SaveTritianosLenguajeUseCase;
import com.service3it.mcsv_tritianos_lenguajes.domain.ports.out.TritianosLenguajeRepositoryPort;

@Service
public class SaveTritianosLenguajeUseCaseImpl implements SaveTritianosLenguajeUseCase {

    private final TritianosLenguajeRepositoryPort tritianosLenguajeRepositoryPort;

    public SaveTritianosLenguajeUseCaseImpl(TritianosLenguajeRepositoryPort tritianosLenguajeRepositoryPort) {
        this.tritianosLenguajeRepositoryPort = tritianosLenguajeRepositoryPort;
    }

    @Override
    @Transactional
    public TritianosLenguaje saveTritianosLenguaje(TritianosLenguaje tritianosLenguaje) {
        return tritianosLenguajeRepositoryPort.saveTritianosLenguaje(tritianosLenguaje);
    }


}
