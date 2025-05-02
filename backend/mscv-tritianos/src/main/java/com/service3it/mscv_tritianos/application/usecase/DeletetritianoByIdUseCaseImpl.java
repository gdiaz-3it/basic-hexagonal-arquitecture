package com.service3it.mscv_tritianos.application.usecase;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service3it.mscv_tritianos.domain.ports.in.DeleteTritianoByIdUseCase;
import com.service3it.mscv_tritianos.domain.ports.out.TritianosRepositoryPort;

@Service
public class DeletetritianoByIdUseCaseImpl implements DeleteTritianoByIdUseCase {

    private final TritianosRepositoryPort tritianosRepositoryPort;

    public DeletetritianoByIdUseCaseImpl(TritianosRepositoryPort tritianosRepositoryPort) {
        this.tritianosRepositoryPort = tritianosRepositoryPort;
    }

    @Override
    @Transactional
    public void deleteTritianoById(Long id) {
        tritianosRepositoryPort.deleteTritianoById(id);
    }

}
