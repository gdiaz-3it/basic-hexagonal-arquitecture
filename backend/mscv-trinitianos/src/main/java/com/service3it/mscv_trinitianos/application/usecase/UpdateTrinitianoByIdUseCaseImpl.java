package com.service3it.mscv_trinitianos.application.usecase;

import com.service3it.mscv_trinitianos.domain.models.Trinitianos;
import com.service3it.mscv_trinitianos.domain.ports.in.UpdateTrinitianoByIdUseCase;
import com.service3it.mscv_trinitianos.domain.ports.out.TrinitianosRepositoryPort;

public class UpdateTrinitianoByIdUseCaseImpl implements UpdateTrinitianoByIdUseCase {

    private final TrinitianosRepositoryPort trinitianosRepositoryPort;

    public UpdateTrinitianoByIdUseCaseImpl(TrinitianosRepositoryPort trinitianosRepositoryPort) {
        this.trinitianosRepositoryPort = trinitianosRepositoryPort;
    }

    @Override
    public Trinitianos updateTrinitianoById(Long id, Trinitianos trinitianos) {
        return trinitianosRepositoryPort.updateTrinitianoById(id, trinitianos);
    }

}
