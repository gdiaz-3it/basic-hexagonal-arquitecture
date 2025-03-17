package com.service3it.mscv_trinitianos.application.usecase;

import com.service3it.mscv_trinitianos.domain.models.Trinitianos;
import com.service3it.mscv_trinitianos.domain.ports.in.GetTrinitianosByIdUseCase;
import com.service3it.mscv_trinitianos.domain.ports.out.TrinitianosRepositoryPort;

public class GetTrinitianosByIdUseCaseImpl implements GetTrinitianosByIdUseCase {

    private final TrinitianosRepositoryPort trinitianosRepositoryPort;

    public GetTrinitianosByIdUseCaseImpl(TrinitianosRepositoryPort trinitianosRepositoryPort) {
        this.trinitianosRepositoryPort = trinitianosRepositoryPort;
    }

    @Override
    public Trinitianos getTrinitianosById(Long id) {
        return trinitianosRepositoryPort.getTrinitianosById(id);
    }


}
