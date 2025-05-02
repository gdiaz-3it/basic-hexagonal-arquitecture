package com.service3it.mcsv_trinitianos_aplicaciones.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service3it.mcsv_trinitianos_aplicaciones.client.AplicacionesServiceClient;
import com.service3it.mcsv_trinitianos_aplicaciones.dto.AplicacionesDto;
import com.service3it.mcsv_trinitianos_aplicaciones.dto.TrinitianosAplicacionesDto;
import com.service3it.mcsv_trinitianos_aplicaciones.model.TrinitianosAplicacionesEntity;
import com.service3it.mcsv_trinitianos_aplicaciones.repository.TrinitianosAplicacionesRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TrinitianosAplicacionesServiceImpl implements TrinitianosAplicacionesService {

    private final TrinitianosAplicacionesRepository trinitianosAplicacionesRepository;
    private final AplicacionesServiceClient aplicacionesServiceClient;

    public TrinitianosAplicacionesServiceImpl(TrinitianosAplicacionesRepository trinitianosAplicacionesRepository, AplicacionesServiceClient aplicacionesServiceClient) {
        this.trinitianosAplicacionesRepository = trinitianosAplicacionesRepository;
        this.aplicacionesServiceClient = aplicacionesServiceClient;
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<TrinitianosAplicacionesEntity> findAll() {
        return trinitianosAplicacionesRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<TrinitianosAplicacionesEntity> findByNivel(String nivel) {
        if (nivel == null || nivel.trim().isEmpty()) {
            throw new IllegalArgumentException("El nivel no puede ser nulo o vacío");
        }
        return trinitianosAplicacionesRepository.findByNivel(nivel);
    }

    @Override
    @Transactional
    public TrinitianosAplicacionesEntity save(TrinitianosAplicacionesEntity trinitianosAplicacionesEntity) {
        return trinitianosAplicacionesRepository.save(trinitianosAplicacionesEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TrinitianosAplicacionesDto> findAllTrinitianosAplicacionesWithAplicaciones() {
        List<TrinitianosAplicacionesEntity> trinitianosAplicaciones = trinitianosAplicacionesRepository.findAll();
        List<AplicacionesDto> aplicaciones = aplicacionesServiceClient.findAllTrinitianosAplicacionesWithAplicaciones();

        return trinitianosAplicaciones.stream().map(trinitianosAplicacion -> {
                    TrinitianosAplicacionesDto trinitianosAplicacionesDto = new TrinitianosAplicacionesDto();
                    trinitianosAplicacionesDto.setId(trinitianosAplicacion.getId());
                    trinitianosAplicacionesDto.setRut(trinitianosAplicacion.getRut());
                    trinitianosAplicacionesDto.setNivel(trinitianosAplicacion.getNivel());

                    List<AplicacionesDto> aplicacionesfiltaradas = aplicaciones.stream()
                            .filter(aplicacion -> aplicacion.getNivel().equals(trinitianosAplicacion.getNivel()))
                            .collect(Collectors.toList());

                    trinitianosAplicacionesDto.setAplicacion(aplicacionesfiltaradas);
                    return trinitianosAplicacionesDto;
        }).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<TrinitianosAplicacionesDto> findAllTrinitianosAplicacionesWithAplicacionByNivel(String nivel) {
        List<TrinitianosAplicacionesEntity> trinitianosAplicaciones = trinitianosAplicacionesRepository.findAll();
        List<AplicacionesDto> aplicaciones = aplicacionesServiceClient.getAplicacionByNivel(nivel);
        
        return trinitianosAplicaciones.stream()
                        .filter(trinitianosAplicacion -> trinitianosAplicacion.getNivel().equals(nivel))
                        .map(trinitianosAplicacion -> {
                            TrinitianosAplicacionesDto trinitianosAplicacionesDto = new TrinitianosAplicacionesDto();
                            trinitianosAplicacionesDto.setId(trinitianosAplicacion.getId());
                            trinitianosAplicacionesDto.setRut(trinitianosAplicacion.getRut());
                            trinitianosAplicacionesDto.setNivel(trinitianosAplicacion.getNivel());

                            List<AplicacionesDto> aplicacionesfiltaradas = aplicaciones.stream()
                                    .filter(aplicacion -> aplicacion.getNivel().equals(trinitianosAplicacion.getNivel()))
                                    .collect(Collectors.toList());

                            trinitianosAplicacionesDto.setAplicacion(aplicacionesfiltaradas);
                            return trinitianosAplicacionesDto;
                        }).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<TrinitianosAplicacionesEntity> findByRut(String rut) {
        if (rut == null || rut.trim().isEmpty()) {
            throw new IllegalArgumentException("El nivel no puede ser nulo o vacío");
        }
        return trinitianosAplicacionesRepository.findByRut(rut);
    }

}
