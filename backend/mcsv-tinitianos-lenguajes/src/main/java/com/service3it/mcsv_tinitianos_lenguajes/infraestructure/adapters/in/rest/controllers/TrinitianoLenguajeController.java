package com.service3it.mcsv_tinitianos_lenguajes.infraestructure.adapters.in.rest.controllers;

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

import com.service3it.mcsv_tinitianos_lenguajes.domain.models.TrinitianosLenguaje;
import com.service3it.mcsv_tinitianos_lenguajes.domain.ports.in.DeleteTrinitianosLenguajeByIdUseCase;
import com.service3it.mcsv_tinitianos_lenguajes.domain.ports.in.GetAllTrinitianosLenguajeUseCase;
import com.service3it.mcsv_tinitianos_lenguajes.domain.ports.in.GetTrinitianosLenguajeByIdUseCase;
import com.service3it.mcsv_tinitianos_lenguajes.domain.ports.in.SaveTritianosLenguajeUseCase;
import com.service3it.mcsv_tinitianos_lenguajes.domain.ports.in.UpdateTrinitianosLenguajeByIdUseCase;
import com.service3it.mcsv_tinitianos_lenguajes.infraestructure.adapters.in.rest.dto.TrinitianosLenguajeDTO;
import com.service3it.mcsv_tinitianos_lenguajes.infraestructure.adapters.in.rest.mapper.TrinitianosLenguajeDtoToDomainMapper;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/trinitianos-lenguajes")
@AllArgsConstructor
public class TrinitianoLenguajeController {

    private final DeleteTrinitianosLenguajeByIdUseCase deleteTrinitianoLenguajeByIdUseCase;
    private final SaveTritianosLenguajeUseCase saveTrinitianosLenguajeUseCase;
    private final GetTrinitianosLenguajeByIdUseCase getTrinitianosLenguajeByIdUseCase;
    private final GetAllTrinitianosLenguajeUseCase getAllTrinitianosLenguajeUseCase;
    private final UpdateTrinitianosLenguajeByIdUseCase updateTrinitianosLenguajeByIdUseCase;

    @GetMapping
    public ResponseEntity<List<TrinitianosLenguajeDTO>> getAllTrinitianosLenguaje() {
        try {
            List<TrinitianosLenguaje> trinitianosLenguajes = getAllTrinitianosLenguajeUseCase.getAllTrinitianosLenguaje();
            List<TrinitianosLenguajeDTO> trinitianosLenguajesDTO = trinitianosLenguajes.stream()
                    .map(TrinitianosLenguajeDtoToDomainMapper::toDto)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(trinitianosLenguajesDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // Internal Server Error
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrinitianosLenguajeDTO> getTrinitianosLenguajeById(@PathVariable Long id) {
        TrinitianosLenguaje trinitianosLenguaje = getTrinitianosLenguajeByIdUseCase.getTrinitianosLenguajeById(id);
        if (trinitianosLenguaje != null) {
            return ResponseEntity.ok(TrinitianosLenguajeDtoToDomainMapper.toDto(trinitianosLenguaje));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<TrinitianosLenguajeDTO> saveTrinitianosLenguaje(@RequestBody TrinitianosLenguajeDTO trinitianosLenguajeDTO) {
        TrinitianosLenguaje trinitianosLenguaje = TrinitianosLenguajeDtoToDomainMapper.toDomain(trinitianosLenguajeDTO);
        TrinitianosLenguaje savedTrinitianosLenguaje = saveTrinitianosLenguajeUseCase.saveTrinitianosLenguaje(trinitianosLenguaje);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(TrinitianosLenguajeDtoToDomainMapper.toDto(savedTrinitianosLenguaje));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrinitianosLenguajeById(@PathVariable Long id) {
        try {
            deleteTrinitianoLenguajeByIdUseCase.deleteTrinitianosLenguajeById(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TrinitianosLenguajeDTO> updateTrinitianosLenguajeById(@PathVariable Long id, @RequestBody TrinitianosLenguajeDTO trinitianosLenguajeDTO) {
        try {
            TrinitianosLenguaje trinitianosLenguaje = TrinitianosLenguajeDtoToDomainMapper.toDomain(trinitianosLenguajeDTO);
            TrinitianosLenguaje updatedTrinitianosLenguaje = updateTrinitianosLenguajeByIdUseCase.updateTrinitianosLenguajeById(id, trinitianosLenguaje);
            return ResponseEntity.ok(TrinitianosLenguajeDtoToDomainMapper.toDto(updatedTrinitianosLenguaje));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}   
