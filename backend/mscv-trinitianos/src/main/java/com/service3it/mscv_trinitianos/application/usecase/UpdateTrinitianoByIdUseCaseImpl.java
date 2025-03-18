package com.service3it.mscv_trinitianos.application.usecase;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service3it.mscv_trinitianos.domain.models.Trinitianos;
import com.service3it.mscv_trinitianos.domain.ports.in.UpdateTrinitianoByIdUseCase;
import com.service3it.mscv_trinitianos.domain.ports.out.TrinitianosRepositoryPort;

@Service
public class UpdateTrinitianoByIdUseCaseImpl implements UpdateTrinitianoByIdUseCase {

    private final TrinitianosRepositoryPort trinitianosRepositoryPort;

    public UpdateTrinitianoByIdUseCaseImpl(TrinitianosRepositoryPort trinitianosRepositoryPort) {
        this.trinitianosRepositoryPort = trinitianosRepositoryPort;
    }

    @Override
    @Transactional
    public Trinitianos updateTrinitianoById(Long id, Trinitianos trinitianos) {
        return trinitianosRepositoryPort.updateTrinitianoById(id, trinitianos);
    }

}
