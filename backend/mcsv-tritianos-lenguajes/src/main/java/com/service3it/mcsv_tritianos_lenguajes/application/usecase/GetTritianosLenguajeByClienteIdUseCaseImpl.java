package com.service3it.mcsv_tritianos_lenguajes.application.usecase;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service3it.mcsv_tritianos_lenguajes.domain.models.TritianosLenguaje;
import com.service3it.mcsv_tritianos_lenguajes.domain.ports.in.GetTritianosLenguajeByClienteIdUseCase;
import com.service3it.mcsv_tritianos_lenguajes.domain.ports.out.TritianosLenguajeRepositoryPort;

@Service
public class GetTritianosLenguajeByClienteIdUseCaseImpl implements GetTritianosLenguajeByClienteIdUseCase {

    private final TritianosLenguajeRepositoryPort tritianosLenguajeRepositoryPort;

    public GetTritianosLenguajeByClienteIdUseCaseImpl(TritianosLenguajeRepositoryPort tritianosLenguajeRepositoryPort) {
        this.tritianosLenguajeRepositoryPort = tritianosLenguajeRepositoryPort;
    }

    @Override
    @Transactional(readOnly = true)
    public List<TritianosLenguaje> getTritianosLenguajesByClienteId(Long clienteId) {
        return tritianosLenguajeRepositoryPort.getTritianosLenguajesByClienteId(clienteId);
    }



}
