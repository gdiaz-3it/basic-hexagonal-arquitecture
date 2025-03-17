package com.service3it.mscv_trinitianos.application.usecase;

import com.service3it.mscv_trinitianos.domain.ports.in.DeleteTrinitianoByIdUseCase;
import com.service3it.mscv_trinitianos.domain.ports.out.TrinitianosRepositoryPort;

public class DeleteTrinitianoByIdUseCaseImpl implements DeleteTrinitianoByIdUseCase {

    private final TrinitianosRepositoryPort trinitianosRepositoryPort;

    public DeleteTrinitianoByIdUseCaseImpl(TrinitianosRepositoryPort trinitianosRepositoryPort) {
        this.trinitianosRepositoryPort = trinitianosRepositoryPort;
    }

    @Override
    public void deleteTrinitianoById(Long id) {
        trinitianosRepositoryPort.deleteTrinitianoById(id);
    }

}
