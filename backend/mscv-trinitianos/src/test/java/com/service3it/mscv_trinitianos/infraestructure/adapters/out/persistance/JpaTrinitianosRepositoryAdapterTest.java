package com.service3it.mscv_trinitianos.infraestructure.adapters.out.persistance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.service3it.mscv_trinitianos.domain.models.Trinitianos;
import com.service3it.mscv_trinitianos.infraestructure.adapters.out.persistance.entities.TrinitianosEntity;
import com.service3it.mscv_trinitianos.infraestructure.adapters.out.persistance.repositories.TrinitianosRepository;

public class JpaTrinitianosRepositoryAdapterTest {

    @Mock
    private TrinitianosRepository trinitianosRepository;

    @InjectMocks
    private JpaTrinitianosRepositoryAdapter adapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldGetTrinitariosById() {
        TrinitianosEntity entity = new TrinitianosEntity(1L, "Juan", "Perez", "juan.perez@example.com", "12345678-9", "+12345678901", "Activo", null, null, null, null, null);
        when(trinitianosRepository.findById(1L)).thenReturn(Optional.of(entity));

        Trinitianos result = adapter.getTrinitianosById(1L);

        assertNotNull(result);
        assertEquals("Juan", result.getNombre());
        verify(trinitianosRepository, times(1)).findById(1L);
    }

    @Test
    void shouldReturnNullWhenTrinitariosByIdNotFound() {
        when(trinitianosRepository.findById(1L)).thenReturn(Optional.empty());

        Trinitianos result = adapter.getTrinitianosById(1L);

        assertNull(result);
        verify(trinitianosRepository, times(1)).findById(1L);
    }

    @Test
    void shouldSaveTrinitarios() {
        Trinitianos trinitarios = new Trinitianos(null, "Juan", "Perez", "juan.perez@example.com", "12345678-9", "+12345678901", "Activo", null, null, null, null, null);
        TrinitianosEntity savedEntity = new TrinitianosEntity(1L, "Juan", "Perez", "juan.perez@example.com", "12345678-9", "+12345678901", "Activo", null, null, null, null, null);

         when(trinitianosRepository.save(any(TrinitianosEntity.class))).thenReturn(savedEntity);

        Trinitianos result = adapter.saveTrinitianos(trinitarios);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(trinitianosRepository, times(1)).save(any(TrinitianosEntity.class));
    }

    @Test
    void shouldGetAllTrinitarios() {
        TrinitianosEntity entity1 = new TrinitianosEntity(1L, "Juan", "Perez", "juan.perez@example.com", "12345678-9", "+12345678901", "Activo", null, null, null, null, null);
        TrinitianosEntity entity2 = new TrinitianosEntity(2L, "Maria", "Gomez", "maria.gomez@example.com", "87654321-K", "+12345678902", "Inactivo", null, null, null, null, null);

        when(trinitianosRepository.findAll()).thenReturn(Arrays.asList(entity1, entity2));

        List<Trinitianos> result = adapter.getAllTrinitianos();

        assertEquals(2, result.size());
        verify(trinitianosRepository, times(1)).findAll();
    }

    @Test
    void shouldDeleteTrinitariosById() {
        doNothing().when(trinitianosRepository).deleteById(1L);

        adapter.deleteTrinitianoById(1L);

        verify(trinitianosRepository, times(1)).deleteById(1L);
    }

    @Test
    void shouldUpdateTrinitariosById() {
        Trinitianos trinitarios = new Trinitianos(null, "Juan Actualizado", "Perez", "juan.perez@example.com", "12345678-9", "+12345678901", "Activo", null, null, null, null, null);
        TrinitianosEntity existingEntity = new TrinitianosEntity(1L, "Juan", "Perez", "juan.perez@example.com", "12345678-9", "+12345678901", "Activo", null, null, null, null, null);
        TrinitianosEntity updatedEntity = new TrinitianosEntity(1L, "Juan Actualizado", "Perez", "juan.perez@example.com", "12345678-9", "+12345678901", "Activo", null, null, null, null, null);

        when(trinitianosRepository.findById(1L)).thenReturn(Optional.of(existingEntity));
        when(trinitianosRepository.save(existingEntity)).thenReturn(updatedEntity);

        Trinitianos result = adapter.updateTrinitianoById(1L, trinitarios);

        assertNotNull(result);
        assertEquals("Juan Actualizado", result.getNombre());
        verify(trinitianosRepository, times(1)).findById(1L);
        verify(trinitianosRepository, times(1)).save(existingEntity);
    }

}
