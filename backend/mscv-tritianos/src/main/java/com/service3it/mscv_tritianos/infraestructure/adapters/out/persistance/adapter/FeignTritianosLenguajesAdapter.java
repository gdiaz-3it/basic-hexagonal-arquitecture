package com.service3it.mscv_tritianos.infraestructure.adapters.out.persistance.adapter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.service3it.mscv_tritianos.domain.models.TritianosLenguajes;
import com.service3it.mscv_tritianos.domain.ports.out.TritianosLenguajesRepositoryPort;
import com.service3it.mscv_tritianos.infraestructure.adapters.out.clients.TritianosLenguajesClient;
import com.service3it.mscv_tritianos.infraestructure.adapters.out.persistance.mapper.TritianosLenguajesMapper;

@Component
public class FeignTritianosLenguajesAdapter implements TritianosLenguajesRepositoryPort  {

    private final TritianosLenguajesClient tritianosLenguajesClient;

    public FeignTritianosLenguajesAdapter(TritianosLenguajesClient tritianosLenguajesClient) {
        this.tritianosLenguajesClient = tritianosLenguajesClient;
    }

    @Override
    public List<TritianosLenguajes> findLenguajesById(Long id) {
        return tritianosLenguajesClient.getTritianosById(id).stream()
                .map(TritianosLenguajesMapper::toDomain)
                .collect(Collectors.toList());
    }

}
