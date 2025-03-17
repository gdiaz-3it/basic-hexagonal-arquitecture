package com.service3it.mscv_trinitianos.infraestructure.controllers;

import java.util.List;

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
import com.service3it.mscv_trinitianos.application.services.TrinitianosService;
import com.service3it.mscv_trinitianos.domain.models.Trinitianos;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api")
public class TrinitianosController {

    private TrinitianosService trinitianosService;

    public TrinitianosController(TrinitianosService trinitianosService) {
        this.trinitianosService = trinitianosService;
    }

    @GetMapping("/trinitianos")
    public ResponseEntity<List<Trinitianos>> getAllTrinitianos() {
        List<Trinitianos> trinitianos = trinitianosService.getAllTrinitianos();
        if (trinitianos != null) {
            return new ResponseEntity<>(trinitianos, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/trinitianos/{id}")
    public ResponseEntity<Trinitianos> getTrinitianosById(@PathVariable Long id) {
        Trinitianos trinitianos = trinitianosService.getTrinitianosById(id);
        if (trinitianos != null) {
            return new ResponseEntity<>(trinitianos, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }   
    }

    @PostMapping("/trinitianos")
    public ResponseEntity<Trinitianos> saveTrinitianos(@RequestBody Trinitianos trinitianos) {
        Trinitianos trinitianosSaved = trinitianosService.saveTrinitianos(trinitianos);
        if (trinitianosSaved != null) {
            return new ResponseEntity<>(trinitianosSaved, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/trinitianos/{id}")
    public ResponseEntity<Void> deleteTrinitianoById(@PathVariable Long id) {
        trinitianosService.deleteTrinitianoById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/trinitianos/{id}")
    public ResponseEntity<Trinitianos> updateTrinitianoById(@PathVariable Long id, @RequestBody Trinitianos trinitianos) {
        try {
            Trinitianos trinitianosUpdated = trinitianosService.updateTrinitianoById(id, trinitianos);
            return ResponseEntity.ok(trinitianosUpdated);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }


}
