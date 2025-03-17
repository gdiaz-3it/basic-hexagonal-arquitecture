package com.service3it.mscv_trinitianos.application.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service3it.mscv_trinitianos.domain.models.Trinitianos;
import com.service3it.mscv_trinitianos.domain.ports.in.DeleteTrinitianoByIdUseCase;
import com.service3it.mscv_trinitianos.domain.ports.in.GetAllTrinitianosUseCase;
import com.service3it.mscv_trinitianos.domain.ports.in.GetTrinitianosByIdUseCase;
import com.service3it.mscv_trinitianos.domain.ports.in.SaveTrinitianosUseCase;
import com.service3it.mscv_trinitianos.domain.ports.in.UpdateTrinitianoByIdUseCase;
import com.service3it.mscv_trinitianos.domain.ports.out.TrinitianosRepositoryPort;

@Service
public class TrinitianosService implements GetTrinitianosByIdUseCase, SaveTrinitianosUseCase, GetAllTrinitianosUseCase, DeleteTrinitianoByIdUseCase, UpdateTrinitianoByIdUseCase {

    private final TrinitianosRepositoryPort trinitianosRepositoryPort;

    public TrinitianosService(TrinitianosRepositoryPort trinitianosRepositoryPort) {
        this.trinitianosRepositoryPort = trinitianosRepositoryPort;
    }


    @Override
    @Transactional(readOnly = true)
    public Trinitianos getTrinitianosById(Long id) {
        return trinitianosRepositoryPort.getTrinitianosById(id);
    }

    @Override
    @Transactional
    public Trinitianos saveTrinitianos(Trinitianos trinitianos) {
        return trinitianosRepositoryPort.saveTrinitianos(trinitianos);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Trinitianos> getAllTrinitianos() {
        return trinitianosRepositoryPort.getAllTrinitianos();
    }

    @Override
    @Transactional
    public void deleteTrinitianoById(Long id) {
        trinitianosRepositoryPort.deleteTrinitianoById(id);
    }

    @Override
    @Transactional
    public Trinitianos updateTrinitianoById(Long id, Trinitianos trinitianos) {
        return trinitianosRepositoryPort.updateTrinitianoById(id, trinitianos);
    }

}
