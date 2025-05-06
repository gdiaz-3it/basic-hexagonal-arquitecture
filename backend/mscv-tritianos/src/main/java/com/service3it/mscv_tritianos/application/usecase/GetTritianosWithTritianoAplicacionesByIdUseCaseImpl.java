package com.service3it.mscv_tritianos.application.usecase;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service3it.mscv_tritianos.domain.models.TritianosConTritianosAplicaciones;
import com.service3it.mscv_tritianos.domain.ports.in.GetTritianosWithTritianoAplicacionByIdUseCase;
import com.service3it.mscv_tritianos.domain.ports.out.TritianosConTritianosAplicacionesRepositoryPort;

@Service
public class GetTritianosWithTritianoAplicacionesByIdUseCaseImpl implements GetTritianosWithTritianoAplicacionByIdUseCase {

    private final TritianosConTritianosAplicacionesRepositoryPort tritianosConTritianosAplicacionesRepositoryPort;

    public GetTritianosWithTritianoAplicacionesByIdUseCaseImpl(TritianosConTritianosAplicacionesRepositoryPort tritianosConTritianosAplicacionesRepositoryPort) {
        this.tritianosConTritianosAplicacionesRepositoryPort = tritianosConTritianosAplicacionesRepositoryPort;
    }

    @Override
    @Transactional(readOnly = true)
    public List<TritianosConTritianosAplicaciones> getTritianosWithTritianoAplicacionesUseCaseById(Long id) {
        return tritianosConTritianosAplicacionesRepositoryPort.getTritianosWithTritianoAplicacionesUseCaseById(id);
    }
}
