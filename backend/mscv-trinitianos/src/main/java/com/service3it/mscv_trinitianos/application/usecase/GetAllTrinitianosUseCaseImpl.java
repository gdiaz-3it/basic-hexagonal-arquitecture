package com.service3it.mscv_trinitianos.application.usecase;

import java.util.List;

import com.service3it.mscv_trinitianos.domain.models.Trinitianos;
import com.service3it.mscv_trinitianos.domain.ports.in.GetAllTrinitianosUseCase;
import com.service3it.mscv_trinitianos.domain.ports.out.TrinitianosRepositoryPort;

public class GetAllTrinitianosUseCaseImpl implements GetAllTrinitianosUseCase {

    private final TrinitianosRepositoryPort trinitianosRepositoryPort;

    public GetAllTrinitianosUseCaseImpl(TrinitianosRepositoryPort trinitianosRepositoryPort) {
        this.trinitianosRepositoryPort = trinitianosRepositoryPort;
    }

    @Override
    public List<Trinitianos> getAllTrinitianos() {
        return trinitianosRepositoryPort.getAllTrinitianos();
    }

}
