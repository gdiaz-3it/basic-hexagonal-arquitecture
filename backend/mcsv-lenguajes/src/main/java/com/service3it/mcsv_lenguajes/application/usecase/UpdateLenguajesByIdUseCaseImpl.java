package com.service3it.mcsv_lenguajes.application.usecase;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service3it.mcsv_lenguajes.domain.models.Lenguajes;
import com.service3it.mcsv_lenguajes.domain.ports.in.UpdateLenguajesByIdUseCase;
import com.service3it.mcsv_lenguajes.domain.ports.out.LenguajesRepositoryPort;

@Service
public class UpdateLenguajesByIdUseCaseImpl implements UpdateLenguajesByIdUseCase {
    
    private final LenguajesRepositoryPort lenguajesRepositoryPort;

    public UpdateLenguajesByIdUseCaseImpl(LenguajesRepositoryPort lenguajesRepositoryPort) {
        this.lenguajesRepositoryPort = lenguajesRepositoryPort;
    }

    @Override
    @Transactional
    public Lenguajes updateLenguajesById(Long id, Lenguajes lenguajes) {
        return lenguajesRepositoryPort.updateLenguajesById(id, lenguajes);
    }

}
