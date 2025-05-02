package com.service3it.mscv_tritianos.application.usecase;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.service3it.mscv_tritianos.domain.models.Tritianos;
import com.service3it.mscv_tritianos.domain.ports.in.GetTritianosWithTritianoAplicacionesUseCase;
import com.service3it.mscv_tritianos.domain.ports.out.TritianosRepositoryPort;
import com.service3it.mscv_tritianos.infraestructure.adapters.in.rest.dto.TritianosAplicacionesDto;
import com.service3it.mscv_tritianos.infraestructure.adapters.in.rest.dto.TritianosConTritianoAplicacionesDTO;
import com.service3it.mscv_tritianos.infraestructure.adapters.out.clients.TritianosAplicacionesClient;

@Service
public class GetTritianosWithTritianoAplicacionesUseCaseImpl implements GetTritianosWithTritianoAplicacionesUseCase {

    private final TritianosRepositoryPort tritianosRepositoryPort;
    private final TritianosAplicacionesClient aplicacionesClient;

    public GetTritianosWithTritianoAplicacionesUseCaseImpl(TritianosRepositoryPort tritianosRepositoryPort, TritianosAplicacionesClient aplicacionesClient) {
        this.tritianosRepositoryPort = tritianosRepositoryPort;
        this.aplicacionesClient = aplicacionesClient;
    }

    @Override
    public List<TritianosConTritianoAplicacionesDTO> getTritianosWithTritianoAplicacionesUseCase() {
        List<Tritianos> tritianos = tritianosRepositoryPort.getAllTritianos();

        return tritianos.stream().map(tritiano -> {
            List<TritianosAplicacionesDto> aplicaciones = aplicacionesClient.getTritianosByRut(tritiano.getRut());

            return new TritianosConTritianoAplicacionesDTO(
                    tritiano.getId(),
                    tritiano.getNombre(),
                    tritiano.getApellido(),
                    tritiano.getRut(),
                    tritiano.getTelefono(),
                    tritiano.getEstado(),
                    tritiano.getEnlaceBizneo(),
                    tritiano.getEnlaceHubspot(),
                    tritiano.getEnlaceJira(),
                    aplicaciones
            );
        }).collect(Collectors.toList());
    }
}
