package com.service3it.mscv_trinitianos.application.usecase;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service3it.mscv_trinitianos.domain.ports.in.DeleteTrinitianoByIdUseCase;
import com.service3it.mscv_trinitianos.domain.ports.out.TrinitianosRepositoryPort;

@Service
public class DeleteTrinitianoByIdUseCaseImpl implements DeleteTrinitianoByIdUseCase {

    private final TrinitianosRepositoryPort trinitianosRepositoryPort;

    public DeleteTrinitianoByIdUseCaseImpl(TrinitianosRepositoryPort trinitianosRepositoryPort) {
        this.trinitianosRepositoryPort = trinitianosRepositoryPort;
    }

    @Override
    @Transactional
    public void deleteTrinitianoById(Long id) {
        trinitianosRepositoryPort.deleteTrinitianoById(id);
    }

}
