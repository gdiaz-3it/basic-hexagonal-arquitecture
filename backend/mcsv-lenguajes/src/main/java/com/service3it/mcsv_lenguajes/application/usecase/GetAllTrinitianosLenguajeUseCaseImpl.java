package com.service3it.mcsv_lenguajes.application.usecase;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.service3it.mcsv_lenguajes.domain.models.TrinitianosLenguaje;
import com.service3it.mcsv_lenguajes.domain.ports.in.GetAllTrinitianosLenguajeUseCase;
import com.service3it.mcsv_lenguajes.domain.ports.out.TrinitianosLenguajeRepositoryPort;

public class GetAllTrinitianosLenguajeUseCaseImpl implements GetAllTrinitianosLenguajeUseCase {

    private final TrinitianosLenguajeRepositoryPort trinitianosLenguajeRepositoryPort;

    public GetAllTrinitianosLenguajeUseCaseImpl(TrinitianosLenguajeRepositoryPort trinitianosLenguajeRepositoryPort) {
        this.trinitianosLenguajeRepositoryPort = trinitianosLenguajeRepositoryPort;
    }

    @Override
    @Transactional(readOnly = true)
    public List<TrinitianosLenguaje> getAllTrinitianosLenguaje() {
        return trinitianosLenguajeRepositoryPort.getAllTrinitianosLenguaje();
    }

}
