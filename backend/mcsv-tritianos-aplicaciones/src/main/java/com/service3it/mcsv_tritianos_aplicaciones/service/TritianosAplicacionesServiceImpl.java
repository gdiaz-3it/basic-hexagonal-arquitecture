package com.service3it.mcsv_tritianos_aplicaciones.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service3it.mcsv_tritianos_aplicaciones.client.AplicacionesServiceClient;
import com.service3it.mcsv_tritianos_aplicaciones.dto.AplicacionesDto;
import com.service3it.mcsv_tritianos_aplicaciones.dto.TritianosAplicacionesDto;
import com.service3it.mcsv_tritianos_aplicaciones.model.TritianosAplicacionesEntity;
import com.service3it.mcsv_tritianos_aplicaciones.repository.TritianosAplicacionesRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TritianosAplicacionesServiceImpl implements TritianosAplicacionesService {

    private final TritianosAplicacionesRepository tritianosAplicacionesRepository;
    private final AplicacionesServiceClient aplicacionesServiceClient;

    public TritianosAplicacionesServiceImpl(TritianosAplicacionesRepository tritianosAplicacionesRepository, AplicacionesServiceClient aplicacionesServiceClient) {
        this.tritianosAplicacionesRepository = tritianosAplicacionesRepository;
        this.aplicacionesServiceClient = aplicacionesServiceClient;
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<TritianosAplicacionesEntity> findAll() {
        return tritianosAplicacionesRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<TritianosAplicacionesEntity> findByNivel(String nivel) {
        if (nivel == null || nivel.trim().isEmpty()) {
            throw new IllegalArgumentException("El nivel no puede ser nulo o vacío");
        }
        return tritianosAplicacionesRepository.findByNivel(nivel);
    }

    @Override
    @Transactional
    public TritianosAplicacionesEntity save(TritianosAplicacionesEntity tritianosAplicacionesEntity) {
        return tritianosAplicacionesRepository.save(tritianosAplicacionesEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TritianosAplicacionesDto> findAllTritianosAplicacionesWithAplicaciones() {
        List<TritianosAplicacionesEntity> tritianosAplicaciones = tritianosAplicacionesRepository.findAll();
        List<AplicacionesDto> aplicaciones = aplicacionesServiceClient.findAllTritianosAplicacionesWithAplicaciones();

        return tritianosAplicaciones.stream().map(tritianosAplicacion -> {
                    TritianosAplicacionesDto tritianosAplicacionesDto = new TritianosAplicacionesDto();
                    tritianosAplicacionesDto.setId(tritianosAplicacion.getId());
                    tritianosAplicacionesDto.setRut(tritianosAplicacion.getRut());
                    tritianosAplicacionesDto.setNivel(tritianosAplicacion.getNivel());

                    List<AplicacionesDto> aplicacionesfiltaradas = aplicaciones.stream()
                            .filter(aplicacion -> aplicacion.getNivel().equals(tritianosAplicacion.getNivel()))
                            .collect(Collectors.toList());

                    tritianosAplicacionesDto.setAplicacion(aplicacionesfiltaradas);
                    return tritianosAplicacionesDto;
        }).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<TritianosAplicacionesDto> findAllTritianosAplicacionesWithAplicacionByNivel(String nivel) {
        List<TritianosAplicacionesEntity> tritianosAplicaciones = tritianosAplicacionesRepository.findAll();
        List<AplicacionesDto> aplicaciones = aplicacionesServiceClient.getAplicacionByNivel(nivel);
        
        return tritianosAplicaciones.stream()
                        .filter(tritianosAplicacion -> tritianosAplicacion.getNivel().equals(nivel))
                        .map(tritianosAplicacion -> {
                            TritianosAplicacionesDto tritianosAplicacionesDto = new TritianosAplicacionesDto();
                            tritianosAplicacionesDto.setId(tritianosAplicacion.getId());
                            tritianosAplicacionesDto.setRut(tritianosAplicacion.getRut());
                            tritianosAplicacionesDto.setNivel(tritianosAplicacion.getNivel());

                            List<AplicacionesDto> aplicacionesfiltaradas = aplicaciones.stream()
                                    .filter(aplicacion -> aplicacion.getNivel().equals(tritianosAplicacion.getNivel()))
                                    .collect(Collectors.toList());

                            tritianosAplicacionesDto.setAplicacion(aplicacionesfiltaradas);
                            return tritianosAplicacionesDto;
                        }).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<TritianosAplicacionesEntity> findByRut(String rut) {
        if (rut == null || rut.trim().isEmpty()) {
            throw new IllegalArgumentException("El nivel no puede ser nulo o vacío");
        }
        return tritianosAplicacionesRepository.findByRut(rut);
    }

}
