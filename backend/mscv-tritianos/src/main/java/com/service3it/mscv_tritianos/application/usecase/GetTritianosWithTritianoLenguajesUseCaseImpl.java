package com.service3it.mscv_tritianos.application.usecase;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service3it.mscv_tritianos.domain.models.TritianosConTritianosLenguajes;
import com.service3it.mscv_tritianos.domain.ports.in.GetTritianosWithTritianoLenguajesUseCase;
import com.service3it.mscv_tritianos.domain.ports.out.TritianosConTritianosLenguajesRepositoryPort;

@Service
public class GetTritianosWithTritianoLenguajesUseCaseImpl implements GetTritianosWithTritianoLenguajesUseCase {

    private final TritianosConTritianosLenguajesRepositoryPort tritianosConTritianosLenguajesRepositoryPort;

    public GetTritianosWithTritianoLenguajesUseCaseImpl(TritianosConTritianosLenguajesRepositoryPort tritianosConTritianosLenguajesRepositoryPort) {
        this.tritianosConTritianosLenguajesRepositoryPort = tritianosConTritianosLenguajesRepositoryPort;
    }

    @Override
    @Transactional(readOnly = true)
    public List<TritianosConTritianosLenguajes> getTritianosWithTritianoLenguajesUseCase() {
        return tritianosConTritianosLenguajesRepositoryPort.getTritianosWithTritianoLenguajesUseCase();
    }

}
