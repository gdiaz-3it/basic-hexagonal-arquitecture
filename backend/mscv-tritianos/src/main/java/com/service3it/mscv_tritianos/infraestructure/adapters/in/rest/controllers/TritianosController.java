package com.service3it.mscv_tritianos.infraestructure.adapters.in.rest.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.service3it.mscv_tritianos.domain.models.Tritianos;
import com.service3it.mscv_tritianos.domain.models.TritianosConTritianosAplicaciones;
import com.service3it.mscv_tritianos.domain.models.TritianosConTritianosLenguajes;
import com.service3it.mscv_tritianos.domain.ports.in.*;
import com.service3it.mscv_tritianos.infraestructure.adapters.in.rest.dto.TritianosConTritianoAplicacionesDTO;
import com.service3it.mscv_tritianos.infraestructure.adapters.in.rest.dto.TritianosConTritianosLenguajesDTO;
import com.service3it.mscv_tritianos.infraestructure.adapters.in.rest.dto.TritianosDTO;
import com.service3it.mscv_tritianos.infraestructure.adapters.in.rest.mapper.TritianosConTritianosAplicacionesDtoToDomainMapper;
import com.service3it.mscv_tritianos.infraestructure.adapters.in.rest.mapper.TritianosConTritianosLenguajesDtoToDomainMapper;
import com.service3it.mscv_tritianos.infraestructure.adapters.in.rest.mapper.TritianosDtoToDomainMapper;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/tritianos")
@AllArgsConstructor
public class TritianosController {

    private final DeleteTritianoByIdUseCase deletetritianoById;
    private final GetAllTritianosUseCase getAlltritianos;
    private final GetTritianosByIdUseCase gettritianosById;
    private final SaveTritianosUseCase savetritianos;
    private final UpdateTritianoByIdUseCase updatetritianoById;
    private final GetTritianosWithTritianoAplicacionesUseCase gettritianosWithtritianoAplicacionesUseCase;
    private final GetTritianosWithTritianoLenguajesUseCase gettritianosWithtritianoLenguajesUseCase;
    
    @GetMapping
    public ResponseEntity<List<TritianosDTO>> getAlltritianos() {
        try {
            List<Tritianos> tritianos = getAlltritianos.getAllTritianos();
            List<TritianosDTO> tritianosDTOs = tritianos.stream()
                .map(TritianosDtoToDomainMapper::toDto)
                .collect(Collectors.toList());
            return ResponseEntity.ok(tritianosDTOs);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<TritianosDTO> gettritianosById(@PathVariable Long id) {
        Tritianos tritianos = gettritianosById.getTritianosById(id);
        if (tritianos != null) {
            return ResponseEntity.ok(TritianosDtoToDomainMapper.toDto(tritianos));
        } else {
            return ResponseEntity.notFound().build();
        }   
    }

    @PostMapping
    public ResponseEntity<TritianosDTO> savetritianos(@Validated @RequestBody TritianosDTO tritianosDTO) {
    Tritianos domain = TritianosDtoToDomainMapper.toDomain(tritianosDTO);
    Tritianos saved = savetritianos.saveTritianos(domain);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(TritianosDtoToDomainMapper.toDto(saved));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletetritianoById(@PathVariable Long id) {
        try {
            deletetritianoById.deleteTritianoById(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TritianosDTO> updatetritianoById(@PathVariable Long id, @Validated @RequestBody TritianosDTO tritianosDTO) {
        try {
            Tritianos tritianosDomain = TritianosDtoToDomainMapper.toDomain(tritianosDTO);
            Tritianos tritianosUpdated = updatetritianoById.updateTritianoById(id, tritianosDomain);
            return ResponseEntity.ok(TritianosDtoToDomainMapper.toDto(tritianosUpdated));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/aplicaciones/all")
    public ResponseEntity<List<TritianosConTritianoAplicacionesDTO>> getTritianosWithTritianoAplicaciones() {
            List<TritianosConTritianosAplicaciones> domainList = 
                gettritianosWithtritianoAplicacionesUseCase.getTritianosWithTritianoAplicacionesUseCase();

            List<TritianosConTritianoAplicacionesDTO> dtoList = domainList.stream()
                .map(TritianosConTritianosAplicacionesDtoToDomainMapper::toDto)
                .collect(Collectors.toList());

            return ResponseEntity.ok(dtoList);
    }

    @GetMapping("/lenguajes/all")
    public ResponseEntity<List<TritianosConTritianosLenguajesDTO>> getTritianosWithTritianoLenguajes() {
        List<TritianosConTritianosLenguajes> domainList = 
            gettritianosWithtritianoLenguajesUseCase.getTritianosWithTritianoLenguajesUseCase();

        List<TritianosConTritianosLenguajesDTO> dtoList = domainList.stream()
            .map(TritianosConTritianosLenguajesDtoToDomainMapper::toDto)
            .collect(Collectors.toList());

        return ResponseEntity.ok(dtoList);
    }
}
