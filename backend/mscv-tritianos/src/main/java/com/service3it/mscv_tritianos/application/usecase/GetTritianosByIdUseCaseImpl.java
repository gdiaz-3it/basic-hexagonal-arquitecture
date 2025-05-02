package com.service3it.mscv_tritianos.application.usecase;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service3it.mscv_tritianos.domain.models.Tritianos;
import com.service3it.mscv_tritianos.domain.ports.in.GetTritianosByIdUseCase;
import com.service3it.mscv_tritianos.domain.ports.out.TritianosRepositoryPort;

@Service
public class GetTritianosByIdUseCaseImpl implements GetTritianosByIdUseCase {

    private final TritianosRepositoryPort tritianosRepositoryPort;

    public GetTritianosByIdUseCaseImpl(TritianosRepositoryPort tritianosRepositoryPort) {
        this.tritianosRepositoryPort = tritianosRepositoryPort;
    }

    @Override
    @Transactional(readOnly = true)
    public Tritianos getTritianosById(Long id) {
        return tritianosRepositoryPort.getTritianosById(id);
    }


}
