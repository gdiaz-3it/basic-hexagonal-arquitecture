package com.service3it.mscv_tritianos.application.usecase;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service3it.mscv_tritianos.domain.models.Tritianos;
import com.service3it.mscv_tritianos.domain.ports.in.UpdateTritianoByIdUseCase;
import com.service3it.mscv_tritianos.domain.ports.out.TritianosRepositoryPort;

@Service
public class UpdateTritianoByIdUseCaseImpl implements UpdateTritianoByIdUseCase {

    private final TritianosRepositoryPort tritianosRepositoryPort;

    public UpdateTritianoByIdUseCaseImpl(TritianosRepositoryPort tritianosRepositoryPort) {
        this.tritianosRepositoryPort = tritianosRepositoryPort;
    }

    @Override
    @Transactional
    public Tritianos updateTritianoById(Long id, Tritianos tritianos) {
        return tritianosRepositoryPort.updateTritianoById(id, tritianos);
    }

}
