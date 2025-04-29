package com.service3it.mcsv_lenguajes.application.usecase;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service3it.mcsv_lenguajes.domain.models.Lenguajes;
import com.service3it.mcsv_lenguajes.domain.ports.in.SaveLenguajesUseCase;
import com.service3it.mcsv_lenguajes.domain.ports.out.LenguajesRepositoryPort;

@Service
public class SaveLenguajesUseCaseImpl implements SaveLenguajesUseCase {

    private final LenguajesRepositoryPort lenguajesRepositoryPort;

    public SaveLenguajesUseCaseImpl(LenguajesRepositoryPort lenguajesRepositoryPort) {
        this.lenguajesRepositoryPort = lenguajesRepositoryPort;
    }

    @Override
    @Transactional
    public Lenguajes saveLenguajes(Lenguajes lenguajes) {
        return lenguajesRepositoryPort.saveLenguajes(lenguajes);
    }

}
