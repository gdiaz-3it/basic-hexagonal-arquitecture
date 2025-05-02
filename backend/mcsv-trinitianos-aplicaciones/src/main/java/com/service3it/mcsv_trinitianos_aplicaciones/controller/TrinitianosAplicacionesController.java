package com.service3it.mcsv_trinitianos_aplicaciones.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service3it.mcsv_trinitianos_aplicaciones.dto.TrinitianosAplicacionesDto;
import com.service3it.mcsv_trinitianos_aplicaciones.service.TrinitianosAplicacionesService;

import lombok.AllArgsConstructor;

import com.service3it.mcsv_trinitianos_aplicaciones.model.TrinitianosAplicacionesEntity;


@RestController
@RequestMapping("/api/trinitianos-aplicaciones")
@AllArgsConstructor
public class TrinitianosAplicacionesController {

    private final TrinitianosAplicacionesService trinitianosAplicacionesService;

    //Endpoint Clientes

    @GetMapping("/all")
    public ResponseEntity<Iterable<TrinitianosAplicacionesEntity>> findAll() {
        return ResponseEntity.ok(trinitianosAplicacionesService.findAll());
    }

    @GetMapping("/{nivel}")
    public ResponseEntity<List<TrinitianosAplicacionesEntity>> findByNivel(@PathVariable String nivel) {
        List<TrinitianosAplicacionesEntity> trinitianosAplicacion = trinitianosAplicacionesService.findByNivel(nivel);
        if (trinitianosAplicacion.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(trinitianosAplicacion);
    }

    @PostMapping
    public ResponseEntity<TrinitianosAplicacionesEntity> save(@RequestBody TrinitianosAplicacionesEntity trinitianosAplicaciones) {
        TrinitianosAplicacionesEntity nuevaTrinitianosAplicaciones = trinitianosAplicacionesService.save(trinitianosAplicaciones);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaTrinitianosAplicaciones);
    }
    
    //Endpoint TrinitianosAplicaciones con Aplicaciones
    @GetMapping("/aplicaciones/all-with-aplicaciones")
    public ResponseEntity<List<TrinitianosAplicacionesDto>> findAllTrinitianosAplicacionesWithAplicaciones() {
        return ResponseEntity.ok(trinitianosAplicacionesService.findAllTrinitianosAplicacionesWithAplicaciones());
    }

    @GetMapping("/aplicaciones/{nivel}")
    public ResponseEntity<List<TrinitianosAplicacionesDto>> findAllTrinitianosAplicacionesWithAplicacionByNivel(@PathVariable String nivel) {
        return ResponseEntity.ok(trinitianosAplicacionesService.findAllTrinitianosAplicacionesWithAplicacionByNivel(nivel));
    }

    @GetMapping("/cliente/{rut}")
    public ResponseEntity<List<TrinitianosAplicacionesDto>> findByRut(@PathVariable String rut) {
        List<TrinitianosAplicacionesEntity> aplicaciones = trinitianosAplicacionesService.findByRut(rut);
        if (aplicaciones.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        // Convertir las entidades a DTOs
        List<TrinitianosAplicacionesDto> aplicacionesDtos = aplicaciones.stream()
            .map(entity -> new TrinitianosAplicacionesDto(
                    entity.getId(),
                    entity.getRut(),
                    entity.getNivel(),
                    null // Si necesitas incluir aplicaciones, puedes agregar lógica aquí
            ))
            .collect(Collectors.toList());

        return ResponseEntity.ok(aplicacionesDtos);
    }
    
}
