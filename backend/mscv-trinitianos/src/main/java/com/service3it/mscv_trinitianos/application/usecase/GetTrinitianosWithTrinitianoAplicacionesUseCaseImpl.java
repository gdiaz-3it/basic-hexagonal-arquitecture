package com.service3it.mscv_trinitianos.application.usecase;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.service3it.mscv_trinitianos.domain.models.Trinitianos;
import com.service3it.mscv_trinitianos.domain.ports.in.GetTrinitianosWithTrinitianoAplicacionesUseCase;
import com.service3it.mscv_trinitianos.domain.ports.out.TrinitianosRepositoryPort;
import com.service3it.mscv_trinitianos.infraestructure.adapters.in.rest.dto.TrinitianosAplicacionesDto;
import com.service3it.mscv_trinitianos.infraestructure.adapters.in.rest.dto.TrinitianosConTrinitianoAplicacionesDTO;
import com.service3it.mscv_trinitianos.infraestructure.adapters.out.clients.TrinitianosAplicacionesClient;

@Service
public class GetTrinitianosWithTrinitianoAplicacionesUseCaseImpl implements GetTrinitianosWithTrinitianoAplicacionesUseCase {

    private final TrinitianosRepositoryPort trinitianosRepositoryPort;
    private final TrinitianosAplicacionesClient aplicacionesClient;

    public GetTrinitianosWithTrinitianoAplicacionesUseCaseImpl(TrinitianosRepositoryPort trinitianosRepositoryPort, TrinitianosAplicacionesClient aplicacionesClient) {
        this.trinitianosRepositoryPort = trinitianosRepositoryPort;
        this.aplicacionesClient = aplicacionesClient;
    }

    @Override
    public List<TrinitianosConTrinitianoAplicacionesDTO> getTrinitianosWithTrinitianoAplicacionesUseCase() {
        List<Trinitianos> trinitianos = trinitianosRepositoryPort.getAllTrinitianos();

        return trinitianos.stream().map(trinitiano -> {
            List<TrinitianosAplicacionesDto> aplicaciones = aplicacionesClient.getTrinitianosByRut(trinitiano.getRut());

            return new TrinitianosConTrinitianoAplicacionesDTO(
                    trinitiano.getId(),
                    trinitiano.getNombre(),
                    trinitiano.getApellido(),
                    trinitiano.getRut(),
                    trinitiano.getTelefono(),
                    trinitiano.getEstado(),
                    trinitiano.getEnlaceBizneo(),
                    trinitiano.getEnlaceHubspot(),
                    trinitiano.getEnlaceJira(),
                    aplicaciones
            );
        }).collect(Collectors.toList());
    }
}
