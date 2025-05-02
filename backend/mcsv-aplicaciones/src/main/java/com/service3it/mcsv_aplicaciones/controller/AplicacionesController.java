package com.service3it.mcsv_aplicaciones.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service3it.mcsv_aplicaciones.model.AplicacionesEntity;
import com.service3it.mcsv_aplicaciones.service.AplicacionesService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/aplicaciones")
@AllArgsConstructor
public class AplicacionesController {

    private final AplicacionesService aplicacionesService;

    @GetMapping("/all")
    public ResponseEntity<Iterable<AplicacionesEntity>> findAll() {
        return ResponseEntity.ok(aplicacionesService.findAll());
    }

    @GetMapping("/{nivel}")
    public ResponseEntity<List<AplicacionesEntity>> findByNivel (@PathVariable String nivel) {
        List<AplicacionesEntity> aplicaciones = aplicacionesService.findByNivel(nivel);
        if (aplicaciones.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(aplicaciones);
    }

    @PostMapping
    public ResponseEntity<AplicacionesEntity> save(@RequestBody AplicacionesEntity aplicaciones) {
        AplicacionesEntity nuevaAplicaciones = aplicacionesService.save(aplicaciones);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaAplicaciones);
    }

}
