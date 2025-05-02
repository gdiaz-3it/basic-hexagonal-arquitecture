package com.service3it.mcsv_tritianos_lenguajes.infraestructure.adapters.in.rest.controllers;

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

import com.service3it.mcsv_tritianos_lenguajes.domain.models.TritianosLenguaje;
import com.service3it.mcsv_tritianos_lenguajes.domain.ports.in.DeleteTritianosLenguajeByIdUseCase;
import com.service3it.mcsv_tritianos_lenguajes.domain.ports.in.GetAllTritianosLenguajeUseCase;
import com.service3it.mcsv_tritianos_lenguajes.domain.ports.in.GetTritianosLenguajeByIdUseCase;
import com.service3it.mcsv_tritianos_lenguajes.domain.ports.in.SaveTritianosLenguajeUseCase;
import com.service3it.mcsv_tritianos_lenguajes.domain.ports.in.UpdateTritianosLenguajeByIdUseCase;
import com.service3it.mcsv_tritianos_lenguajes.infraestructure.adapters.in.rest.dto.TritianosLenguajeDTO;
import com.service3it.mcsv_tritianos_lenguajes.infraestructure.adapters.in.rest.mapper.TritianosLenguajeDtoToDomainMapper;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/tritianos-lenguajes")
@AllArgsConstructor
public class TritianoLenguajeController {

    private final DeleteTritianosLenguajeByIdUseCase deletetritianoLenguajeByIdUseCase;
    private final SaveTritianosLenguajeUseCase savetritianosLenguajeUseCase;
    private final GetTritianosLenguajeByIdUseCase gettritianosLenguajeByIdUseCase;
    private final GetAllTritianosLenguajeUseCase getAlltritianosLenguajeUseCase;
    private final UpdateTritianosLenguajeByIdUseCase updatetritianosLenguajeByIdUseCase;

    @GetMapping
    public ResponseEntity<List<TritianosLenguajeDTO>> getAllTritianosLenguaje() {
        try {
            List<TritianosLenguaje> tritianosLenguajes = getAlltritianosLenguajeUseCase.getAllTritianosLenguaje();
            List<TritianosLenguajeDTO> tritianosLenguajesDTO = tritianosLenguajes.stream()
                    .map(TritianosLenguajeDtoToDomainMapper::toDto)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(tritianosLenguajesDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // Internal Server Error
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<TritianosLenguajeDTO> getTritianosLenguajeById(@PathVariable Long id) {
        TritianosLenguaje tritianosLenguaje = gettritianosLenguajeByIdUseCase.getTritianosLenguajeById(id);
        if (tritianosLenguaje != null) {
            return ResponseEntity.ok(TritianosLenguajeDtoToDomainMapper.toDto(tritianosLenguaje));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<TritianosLenguajeDTO> saveTritianosLenguaje(@RequestBody TritianosLenguajeDTO tritianosLenguajeDTO) {
        TritianosLenguaje tritianosLenguaje = TritianosLenguajeDtoToDomainMapper.toDomain(tritianosLenguajeDTO);
        TritianosLenguaje savedtritianosLenguaje = savetritianosLenguajeUseCase.saveTritianosLenguaje(tritianosLenguaje);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(TritianosLenguajeDtoToDomainMapper.toDto(savedtritianosLenguaje));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTritianosLenguajeById(@PathVariable Long id) {
        try {
            deletetritianoLenguajeByIdUseCase.deleteTritianosLenguajeById(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TritianosLenguajeDTO> updateTritianosLenguajeById(@PathVariable Long id, @RequestBody TritianosLenguajeDTO tritianosLenguajeDTO) {
        try {
            TritianosLenguaje tritianosLenguaje = TritianosLenguajeDtoToDomainMapper.toDomain(tritianosLenguajeDTO);
            TritianosLenguaje updatedtritianosLenguaje = updatetritianosLenguajeByIdUseCase.updateTritianosLenguajeById(id, tritianosLenguaje);
            return ResponseEntity.ok(TritianosLenguajeDtoToDomainMapper.toDto(updatedtritianosLenguaje));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}   
