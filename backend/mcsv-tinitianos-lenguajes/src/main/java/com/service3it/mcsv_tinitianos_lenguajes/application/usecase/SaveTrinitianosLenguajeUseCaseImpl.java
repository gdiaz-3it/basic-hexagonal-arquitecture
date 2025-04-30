package com.service3it.mcsv_tinitianos_lenguajes.application.usecase;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service3it.mcsv_tinitianos_lenguajes.domain.models.TrinitianosLenguaje;
import com.service3it.mcsv_tinitianos_lenguajes.domain.ports.in.SaveTritianosLenguajeUseCase;
import com.service3it.mcsv_tinitianos_lenguajes.domain.ports.out.TrinitianosLenguajeRepositoryPort;

@Service
public class SaveTrinitianosLenguajeUseCaseImpl implements SaveTritianosLenguajeUseCase {

    private final TrinitianosLenguajeRepositoryPort trinitianosLenguajeRepositoryPort;

    public SaveTrinitianosLenguajeUseCaseImpl(TrinitianosLenguajeRepositoryPort trinitianosLenguajeRepositoryPort) {
        this.trinitianosLenguajeRepositoryPort = trinitianosLenguajeRepositoryPort;
    }

    @Override
    @Transactional
    public TrinitianosLenguaje saveTrinitianosLenguaje(TrinitianosLenguaje trinitianosLenguaje) {
        return trinitianosLenguajeRepositoryPort.saveTrinitianosLenguaje(trinitianosLenguaje);
    }


}
