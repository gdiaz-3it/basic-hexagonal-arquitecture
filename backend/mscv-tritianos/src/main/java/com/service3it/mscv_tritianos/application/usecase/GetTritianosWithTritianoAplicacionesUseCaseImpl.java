package com.service3it.mscv_tritianos.application.usecase;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service3it.mscv_tritianos.domain.models.TritianosConTritianosAplicaciones;
import com.service3it.mscv_tritianos.domain.ports.in.GetTritianosWithTritianoAplicacionesUseCase;
import com.service3it.mscv_tritianos.domain.ports.out.TritianosAplicacionesRepositoryPort;
import com.service3it.mscv_tritianos.domain.ports.out.TritianosConTritianosAplicacionesRepositoryPort;

@Service
public class GetTritianosWithTritianoAplicacionesUseCaseImpl implements GetTritianosWithTritianoAplicacionesUseCase {

    private final TritianosConTritianosAplicacionesRepositoryPort tritianosConTritianosAplicacionesRepositoryPort;

    public GetTritianosWithTritianoAplicacionesUseCaseImpl(TritianosConTritianosAplicacionesRepositoryPort tritianosConTritianosAplicacionesRepositoryPort, TritianosAplicacionesRepositoryPort tritianosAplicacionesRepositoryPort) {
        this.tritianosConTritianosAplicacionesRepositoryPort = tritianosConTritianosAplicacionesRepositoryPort;
    }

    @Override
    @Transactional(readOnly = true)
    public List<TritianosConTritianosAplicaciones> getTritianosWithTritianoAplicacionesUseCase() {
        return tritianosConTritianosAplicacionesRepositoryPort.getTritianosWithTritianoAplicacionesUseCase();
    }
}
