package com.service3it.mscv_tritianos.application.usecase;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service3it.mscv_tritianos.domain.models.Tritianos;
import com.service3it.mscv_tritianos.domain.ports.in.GetAllTritianosUseCase;
import com.service3it.mscv_tritianos.domain.ports.out.TritianosRepositoryPort;

@Service
public class GetAllTritianosUseCaseImpl implements GetAllTritianosUseCase {

    private final TritianosRepositoryPort tritianosRepositoryPort;

    public GetAllTritianosUseCaseImpl(TritianosRepositoryPort tritianosRepositoryPort) {
        this.tritianosRepositoryPort = tritianosRepositoryPort;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Tritianos> getAllTritianos() {
        return tritianosRepositoryPort.getAllTritianos();
    }

}
