package com.service3it.mscv_trinitianos.application.usecase;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service3it.mscv_trinitianos.domain.models.Trinitianos;
import com.service3it.mscv_trinitianos.domain.ports.in.SaveTrinitianosUseCase;
import com.service3it.mscv_trinitianos.domain.ports.out.TrinitianosRepositoryPort;

@Service
public class SaveTrinitianosUseCaseImpl implements SaveTrinitianosUseCase {

    private final TrinitianosRepositoryPort trinitianosRepositoryPort;

    public SaveTrinitianosUseCaseImpl(TrinitianosRepositoryPort trinitianosRepositoryPort) {
        this.trinitianosRepositoryPort = trinitianosRepositoryPort;
    }

    @Override
    @Transactional
    public Trinitianos saveTrinitianos(Trinitianos trinitianos) {
        return trinitianosRepositoryPort.saveTrinitianos(trinitianos);
    }

}
