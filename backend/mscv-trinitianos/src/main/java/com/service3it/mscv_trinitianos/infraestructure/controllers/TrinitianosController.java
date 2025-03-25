package com.service3it.mscv_trinitianos.infraestructure.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.service3it.mscv_trinitianos.application.usecase.*;
import com.service3it.mscv_trinitianos.domain.models.Trinitianos;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class TrinitianosController {

    private final DeleteTrinitianoByIdUseCaseImpl deleteTrinitianoById;
    private final GetAllTrinitianosUseCaseImpl getAllTrinitianos;
    private final GetTrinitianosByIdUseCaseImpl getTrinitianosById;
    private final SaveTrinitianosUseCaseImpl saveTrinitianos;
    private final UpdateTrinitianoByIdUseCaseImpl updateTrinitianoById;
    
    @GetMapping("/trinitianos")
    public ResponseEntity<List<Trinitianos>> getAllTrinitianos() {
        List<Trinitianos> trinitianos = getAllTrinitianos.getAllTrinitianos();
        if (trinitianos != null) {
            return new ResponseEntity<>(trinitianos, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/trinitianos/{id}")
    public ResponseEntity<Trinitianos> getTrinitianosById(@PathVariable Long id) {
        Trinitianos trinitianos = getTrinitianosById.getTrinitianosById(id);
        if (trinitianos != null) {
            return new ResponseEntity<>(trinitianos, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }   
    }

    @PostMapping("/trinitianos")
    public ResponseEntity<Trinitianos> saveTrinitianos(@RequestBody Trinitianos trinitianos) {
        Trinitianos trinitianosSaved = saveTrinitianos.saveTrinitianos(trinitianos);
        if (trinitianosSaved != null) {
            return new ResponseEntity<>(trinitianosSaved, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/trinitianos/{id}")
    public ResponseEntity<Void> deleteTrinitianoById(@PathVariable Long id) {
        deleteTrinitianoById.deleteTrinitianoById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/trinitianos/{id}")
    public ResponseEntity<Trinitianos> updateTrinitianoById(@PathVariable Long id, @RequestBody Trinitianos trinitianos) {
        try {
            Trinitianos trinitianosUpdated = updateTrinitianoById.updateTrinitianoById(id, trinitianos);
            return ResponseEntity.ok(trinitianosUpdated);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }


}
