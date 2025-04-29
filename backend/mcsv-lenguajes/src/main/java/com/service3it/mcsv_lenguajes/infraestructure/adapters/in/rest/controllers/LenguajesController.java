package com.service3it.mcsv_lenguajes.infraestructure.adapters.in.rest.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service3it.mcsv_lenguajes.domain.models.Lenguajes;
import com.service3it.mcsv_lenguajes.domain.ports.in.DeleteLenguajeByIdUseCase;
import com.service3it.mcsv_lenguajes.domain.ports.in.GetAllLenguajesUseCase;
import com.service3it.mcsv_lenguajes.domain.ports.in.GetLenguajesByIdUseCase;
import com.service3it.mcsv_lenguajes.domain.ports.in.SaveLenguajesUseCase;
import com.service3it.mcsv_lenguajes.domain.ports.in.UpdateLenguajesByIdUseCase;
import com.service3it.mcsv_lenguajes.infraestructure.adapters.in.rest.dto.LenguajesDTO;
import com.service3it.mcsv_lenguajes.infraestructure.adapters.in.rest.mapper.LenguajesDtoToDomainMapper;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/lenguajes")
@AllArgsConstructor
public class LenguajesController {

    private final DeleteLenguajeByIdUseCase deleteLenguajeByIdUseCase;
    private final SaveLenguajesUseCase saveLenguajesUseCase;
    private final GetLenguajesByIdUseCase getLenguajesByIdUseCase;
    private final GetAllLenguajesUseCase getAllLenguajesUseCase;
    private final UpdateLenguajesByIdUseCase updateLenguajeUseCase;

    @GetMapping
    public ResponseEntity<List<LenguajesDTO>> getAllLenguajes() {
        try {
            List<Lenguajes> lenguajes = getAllLenguajesUseCase.getAllLenguajes();
            List<LenguajesDTO> lenguajesDTO = lenguajes.stream()
                    .map(LenguajesDtoToDomainMapper::toDto)
                    .collect(Collectors.toList());
                return ResponseEntity.ok(lenguajesDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<LenguajesDTO> getLenguajesById(@PathVariable Long id) {
        Lenguajes lenguajes = getLenguajesByIdUseCase.getLenguajesById(id);
        if (lenguajes != null) {
            return ResponseEntity.ok(LenguajesDtoToDomainMapper.toDto(lenguajes));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<LenguajesDTO> saveLenguajes(@RequestBody LenguajesDTO lenguajesDTO) {
        Lenguajes domain = LenguajesDtoToDomainMapper.toDomain(lenguajesDTO);
        Lenguajes saved = saveLenguajesUseCase.saveLenguajes(domain);
            return ResponseEntity.status(HttpStatus.CREATED)
                .body(LenguajesDtoToDomainMapper.toDto(saved));   
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLenguajeById(@PathVariable Long id) {
        try {
            deleteLenguajeByIdUseCase.deleteLenguajeById(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<LenguajesDTO> updateLenguajeById(@PathVariable Long id, @RequestBody LenguajesDTO lenguajesDTO) {
        try {
            Lenguajes lenguajesDomain = LenguajesDtoToDomainMapper.toDomain(lenguajesDTO);
            Lenguajes lenguajesUpdated = updateLenguajeUseCase.updateLenguajesById(id, lenguajesDomain);
            return ResponseEntity.ok(LenguajesDtoToDomainMapper.toDto(lenguajesUpdated));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); 
        }
    }
}
