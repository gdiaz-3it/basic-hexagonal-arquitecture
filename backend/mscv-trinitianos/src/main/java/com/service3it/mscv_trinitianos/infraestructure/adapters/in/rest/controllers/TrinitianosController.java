package com.service3it.mscv_trinitianos.infraestructure.adapters.in.rest.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.service3it.mscv_trinitianos.domain.models.Trinitianos;
import com.service3it.mscv_trinitianos.domain.ports.in.*;
import com.service3it.mscv_trinitianos.infraestructure.adapters.in.rest.dto.TrinitianosConTrinitianoAplicacionesDTO;
import com.service3it.mscv_trinitianos.infraestructure.adapters.in.rest.dto.TrinitianosDTO;
import com.service3it.mscv_trinitianos.infraestructure.adapters.in.rest.mapper.TrinitianosDtoToDomainMapper;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/trinitianos")
@AllArgsConstructor
public class TrinitianosController {

    private final DeleteTrinitianoByIdUseCase deleteTrinitianoById;
    private final GetAllTrinitianosUseCase getAllTrinitianos;
    private final GetTrinitianosByIdUseCase getTrinitianosById;
    private final SaveTrinitianosUseCase saveTrinitianos;
    private final UpdateTrinitianoByIdUseCase updateTrinitianoById;
    private final GetTrinitianosWithTrinitianoAplicacionesUseCase getTrinitianosWithTrinitianoAplicacionesUseCase;
    
    @GetMapping
    public ResponseEntity<List<TrinitianosDTO>> getAllTrinitianos() {
        try {
            List<Trinitianos> trinitianos = getAllTrinitianos.getAllTrinitianos();
            List<TrinitianosDTO> trinitianosDTOs = trinitianos.stream()
                .map(TrinitianosDtoToDomainMapper::toDto)
                .collect(Collectors.toList());
            return ResponseEntity.ok(trinitianosDTOs);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrinitianosDTO> getTrinitianosById(@PathVariable Long id) {
        Trinitianos trinitianos = getTrinitianosById.getTrinitianosById(id);
        if (trinitianos != null) {
            return ResponseEntity.ok(TrinitianosDtoToDomainMapper.toDto(trinitianos));
        } else {
            return ResponseEntity.notFound().build();
        }   
    }

    @PostMapping
    public ResponseEntity<TrinitianosDTO> saveTrinitianos(@Validated @RequestBody TrinitianosDTO trinitianosDTO) {
    Trinitianos domain = TrinitianosDtoToDomainMapper.toDomain(trinitianosDTO);
    Trinitianos saved = saveTrinitianos.saveTrinitianos(domain);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(TrinitianosDtoToDomainMapper.toDto(saved));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrinitianoById(@PathVariable Long id) {
        try {
            deleteTrinitianoById.deleteTrinitianoById(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TrinitianosDTO> updateTrinitianoById(@PathVariable Long id, @Validated @RequestBody TrinitianosDTO trinitianosDTO) {
        try {
            Trinitianos trinitianosDomain = TrinitianosDtoToDomainMapper.toDomain(trinitianosDTO);
            Trinitianos trinitianosUpdated = updateTrinitianoById.updateTrinitianoById(id, trinitianosDomain);
            return ResponseEntity.ok(TrinitianosDtoToDomainMapper.toDto(trinitianosUpdated));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/aplicaciones/all")
    public List<TrinitianosConTrinitianoAplicacionesDTO> getTrinitianosWithTrinitianoAplicaciones() {
        return getTrinitianosWithTrinitianoAplicacionesUseCase.getTrinitianosWithTrinitianoAplicacionesUseCase();
    }
}
