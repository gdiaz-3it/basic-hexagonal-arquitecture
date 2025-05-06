package com.service3it.mcsv_tritianos_aplicaciones.controller;

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

import com.service3it.mcsv_tritianos_aplicaciones.dto.TritianosAplicacionesResponseDto;
import com.service3it.mcsv_tritianos_aplicaciones.mapper.TritianosAplicacionesMapper;
import com.service3it.mcsv_tritianos_aplicaciones.model.TritianosAplicacionesEntity;
import com.service3it.mcsv_tritianos_aplicaciones.service.TritianosAplicacionesService;

import lombok.AllArgsConstructor;



@RestController
@RequestMapping("/api/tritianos-aplicaciones")
@AllArgsConstructor
public class TritianosAplicacionesController {

    private final TritianosAplicacionesService tritianosAplicacionesService;

    //Endpoint Clientes

    @GetMapping("/all")
    public ResponseEntity<Iterable<TritianosAplicacionesEntity>> findAll() {
        return ResponseEntity.ok(tritianosAplicacionesService.findAll());
    }

    @GetMapping("/{nivel}")
    public ResponseEntity<List<TritianosAplicacionesEntity>> findByNivel(@PathVariable String nivel) {
        List<TritianosAplicacionesEntity> tritianosAplicacion = tritianosAplicacionesService.findByNivel(nivel);
        if (tritianosAplicacion.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(tritianosAplicacion);
    }

    @PostMapping
    public ResponseEntity<TritianosAplicacionesEntity> save(@RequestBody TritianosAplicacionesEntity tritianosAplicaciones) {
        TritianosAplicacionesEntity nuevatritianosAplicaciones = tritianosAplicacionesService.save(tritianosAplicaciones);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevatritianosAplicaciones);
    }

    @GetMapping("/cliente/id/{id}")
    public ResponseEntity<List<TritianosAplicacionesResponseDto>> getAplicacionesByClienteId(@PathVariable Long id) {
        List<TritianosAplicacionesEntity> aplicaciones = tritianosAplicacionesService.getAplicacionesByClienteId(id);
        List<TritianosAplicacionesResponseDto> response = aplicaciones.stream()
            .map(TritianosAplicacionesMapper::toResponseDto)
            .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }
    
}
