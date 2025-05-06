package com.service3it.mscv_tritianos.infraestructure.adapters.out.persistance.adapter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.service3it.mscv_tritianos.domain.models.TritianosAplicaciones;
import com.service3it.mscv_tritianos.domain.ports.out.TritianosAplicacionesRepositoryPort;
import com.service3it.mscv_tritianos.infraestructure.adapters.out.clients.TritianosAplicacionesClient;
import com.service3it.mscv_tritianos.infraestructure.adapters.out.persistance.mapper.TritianosAplicacionesMapper;

@Component
public class FeignTritianosAplicacionesAdapter implements TritianosAplicacionesRepositoryPort {
    
    private final TritianosAplicacionesClient tritianosAplicacionesClient;

    public FeignTritianosAplicacionesAdapter(TritianosAplicacionesClient tritianosAplicacionesClient) {
        this.tritianosAplicacionesClient = tritianosAplicacionesClient;
    }

    public List<TritianosAplicaciones> findAplicacionesById(Long id) {
        return tritianosAplicacionesClient.getTritianosById(id).stream()
                .map(TritianosAplicacionesMapper::toDomain)
                .collect(Collectors.toList());
    }

}
