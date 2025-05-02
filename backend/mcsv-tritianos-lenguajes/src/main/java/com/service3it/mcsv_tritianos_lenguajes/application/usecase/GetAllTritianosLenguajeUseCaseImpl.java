package com.service3it.mcsv_tritianos_lenguajes.application.usecase;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service3it.mcsv_tritianos_lenguajes.domain.models.TritianosLenguaje;
import com.service3it.mcsv_tritianos_lenguajes.domain.ports.in.GetAllTritianosLenguajeUseCase;
import com.service3it.mcsv_tritianos_lenguajes.domain.ports.out.TritianosLenguajeRepositoryPort;

@Service
public class GetAllTritianosLenguajeUseCaseImpl implements GetAllTritianosLenguajeUseCase {

    private final TritianosLenguajeRepositoryPort tritianosLenguajeRepositoryPort;

    public GetAllTritianosLenguajeUseCaseImpl(TritianosLenguajeRepositoryPort tritianosLenguajeRepositoryPort) {
        this.tritianosLenguajeRepositoryPort = tritianosLenguajeRepositoryPort;
    }

    @Override
    @Transactional(readOnly = true)
    public List<TritianosLenguaje> getAllTritianosLenguaje() {
        return tritianosLenguajeRepositoryPort.getAllTritianosLenguaje();
    }

}
