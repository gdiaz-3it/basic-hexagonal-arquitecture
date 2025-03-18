package com.service3it.mscv_trinitianos.application.usecase;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service3it.mscv_trinitianos.domain.models.Trinitianos;
import com.service3it.mscv_trinitianos.domain.ports.in.GetAllTrinitianosUseCase;
import com.service3it.mscv_trinitianos.domain.ports.out.TrinitianosRepositoryPort;

@Service
public class GetAllTrinitianosUseCaseImpl implements GetAllTrinitianosUseCase {

    private final TrinitianosRepositoryPort trinitianosRepositoryPort;

    public GetAllTrinitianosUseCaseImpl(TrinitianosRepositoryPort trinitianosRepositoryPort) {
        this.trinitianosRepositoryPort = trinitianosRepositoryPort;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Trinitianos> getAllTrinitianos() {
        return trinitianosRepositoryPort.getAllTrinitianos();
    }

}
