package com.service3it.mscv_tritianos.infraestructure.adapters.out.persistance.adapter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.service3it.mscv_tritianos.domain.models.TritianosAplicaciones;
import com.service3it.mscv_tritianos.domain.models.TritianosConTritianosAplicaciones;
import com.service3it.mscv_tritianos.domain.ports.out.TritianosAplicacionesRepositoryPort;
import com.service3it.mscv_tritianos.domain.ports.out.TritianosConTritianosAplicacionesRepositoryPort;
import com.service3it.mscv_tritianos.domain.ports.out.TritianosRepositoryPort;
import com.service3it.mscv_tritianos.infraestructure.adapters.out.persistance.mapper.TritianosWithTritianosAplicacionesMapper;

@Component
public class JpaTritianosWithTritianosAplicacionesRepositoryAdapter implements TritianosConTritianosAplicacionesRepositoryPort {

    private final TritianosRepositoryPort tritianosRepositoryPort;
    private final TritianosAplicacionesRepositoryPort tritianosAplicacionesRepositoryPort;

    public JpaTritianosWithTritianosAplicacionesRepositoryAdapter(TritianosRepositoryPort tritianosRepositoryPort, TritianosAplicacionesRepositoryPort tritianosAplicacionesRepositoryPort) {
        this.tritianosRepositoryPort = tritianosRepositoryPort;
        this.tritianosAplicacionesRepositoryPort = tritianosAplicacionesRepositoryPort;
    }

    @Override
    public List<TritianosConTritianosAplicaciones> getTritianosWithTritianoAplicacionesUseCase() {
        return tritianosRepositoryPort.getAllTritianos().stream()
            .map(tritiano -> {
                List<TritianosAplicaciones> aplicaciones = 
                    tritianosAplicacionesRepositoryPort.findAplicacionesByRut(tritiano.getRut());

                return TritianosWithTritianosAplicacionesMapper.map(tritiano, aplicaciones);
            })
            .collect(Collectors.toList());
    }



    

}
