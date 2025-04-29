package com.service3it.mcsv_lenguajes.application.usecase;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service3it.mcsv_lenguajes.domain.models.Lenguajes;
import com.service3it.mcsv_lenguajes.domain.ports.in.GetLenguajesByIdUseCase;
import com.service3it.mcsv_lenguajes.domain.ports.out.LenguajesRepositoryPort;

@Service
public class GetLenguajesByIdUseCaseImpl implements GetLenguajesByIdUseCase {

    private final LenguajesRepositoryPort lenguajesRepositoryPort;

    public GetLenguajesByIdUseCaseImpl(LenguajesRepositoryPort lenguajesRepositoryPort) {
        this.lenguajesRepositoryPort = lenguajesRepositoryPort;
    }

    @Override
    @Transactional(readOnly = true)
    public Lenguajes getLenguajesById(Long id) {
        return lenguajesRepositoryPort.getLenguajesById(id);
    }

}
