package com.service3it.mscv_tritianos.infraestructure.adapters.out.persistance.adapter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.service3it.mscv_tritianos.domain.models.TritianosConTritianosLenguajes;
import com.service3it.mscv_tritianos.domain.models.TritianosLenguajes;
import com.service3it.mscv_tritianos.domain.ports.out.TritianosConTritianosLenguajesRepositoryPort;
import com.service3it.mscv_tritianos.domain.ports.out.TritianosLenguajesRepositoryPort;
import com.service3it.mscv_tritianos.domain.ports.out.TritianosRepositoryPort;
import com.service3it.mscv_tritianos.infraestructure.adapters.out.persistance.mapper.TritianosWithTritianosLenguajesMapper;

@Component
public class JpaTritianosWithTritianosLenguajesRepositoryAdapter implements TritianosConTritianosLenguajesRepositoryPort {

    private final TritianosRepositoryPort tritianosRepositoryPort;
    private final TritianosLenguajesRepositoryPort tritianosLenguajesRepositoryPort;

    public JpaTritianosWithTritianosLenguajesRepositoryAdapter(TritianosRepositoryPort tritianosRepositoryPort, TritianosLenguajesRepositoryPort tritianosLenguajesRepositoryPort) {
        this.tritianosRepositoryPort = tritianosRepositoryPort;
        this.tritianosLenguajesRepositoryPort = tritianosLenguajesRepositoryPort;
    }

    @Override
    public List<TritianosConTritianosLenguajes> getTritianosWithTritianoLenguajesUseCase() {
        return tritianosRepositoryPort.getAllTritianos().stream()
            .map(tritiano -> {
                List<TritianosLenguajes> lenguajes = 
                    tritianosLenguajesRepositoryPort.findLenguajesByRut(tritiano.getRut());

                return TritianosWithTritianosLenguajesMapper.map(tritiano, lenguajes);
            })
            .collect(Collectors.toList()); 
    }

    @Override
    public List<TritianosConTritianosLenguajes> getTritianosWithTritianoLenguajesUseCaseById(Long id) {
        return tritianosRepositoryPort.getAllTritianos().stream()
            .map(tritiano -> {
                List<TritianosLenguajes> lenguajes = 
                    tritianosLenguajesRepositoryPort.findLenguajesById(tritiano.getId());

                return TritianosWithTritianosLenguajesMapper.map(tritiano, lenguajes);
            })
            .collect(Collectors.toList());
    }

}
