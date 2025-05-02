package com.service3it.mscv_tritianos.application.usecase;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service3it.mscv_tritianos.domain.models.Tritianos;
import com.service3it.mscv_tritianos.domain.ports.in.SaveTritianosUseCase;
import com.service3it.mscv_tritianos.domain.ports.out.TritianosRepositoryPort;

@Service
public class SaveTritianosUseCaseImpl implements SaveTritianosUseCase {

    private final TritianosRepositoryPort tritianosRepositoryPort;

    public SaveTritianosUseCaseImpl(TritianosRepositoryPort tritianosRepositoryPort) {
        this.tritianosRepositoryPort = tritianosRepositoryPort;
    }

    @Override
    @Transactional
    public Tritianos saveTritianos(Tritianos tritianos) {
        return tritianosRepositoryPort.saveTritianos(tritianos);
    }

}
