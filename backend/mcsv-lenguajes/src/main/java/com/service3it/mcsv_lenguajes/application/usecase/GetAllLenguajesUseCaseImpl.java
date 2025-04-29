package com.service3it.mcsv_lenguajes.application.usecase;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service3it.mcsv_lenguajes.domain.models.Lenguajes;
import com.service3it.mcsv_lenguajes.domain.ports.in.GetAllLenguajesUseCase;
import com.service3it.mcsv_lenguajes.domain.ports.out.LenguajesRepositoryPort;

@Service
public class GetAllLenguajesUseCaseImpl implements GetAllLenguajesUseCase {

    private final LenguajesRepositoryPort lenguajesRepositoryPort;

    public GetAllLenguajesUseCaseImpl(LenguajesRepositoryPort lenguajesRepositoryPort) {
        this.lenguajesRepositoryPort = lenguajesRepositoryPort;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Lenguajes> getAllLenguajes() {
        return lenguajesRepositoryPort.getAllLenguajes();
    }

}
