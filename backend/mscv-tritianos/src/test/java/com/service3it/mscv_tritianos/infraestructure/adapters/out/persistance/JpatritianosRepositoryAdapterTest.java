package com.service3it.mscv_tritianos.infraestructure.adapters.out.persistance;

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

import com.service3it.mscv_tritianos.domain.models.Tritianos;
import com.service3it.mscv_tritianos.infraestructure.adapters.out.persistance.adapter.JpaTritianosRepositoryAdapter;
import com.service3it.mscv_tritianos.infraestructure.adapters.out.persistance.entities.TritianosEntity;
import com.service3it.mscv_tritianos.infraestructure.adapters.out.persistance.repositories.TritianosRepository;

public class JpatritianosRepositoryAdapterTest {

    @Mock
    private TritianosRepository tritianosRepository;

    @InjectMocks
    private JpaTritianosRepositoryAdapter adapter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldGetTritianosById() {
        TritianosEntity entity = new TritianosEntity(1L, "Juan", "Perez", "juan.perez@example.com", "12345678-9", "+12345678901", "Activo", null, null, null, null, null);
        when(tritianosRepository.findById(1L)).thenReturn(Optional.of(entity));

        Tritianos result = adapter.getTritianosById(1L);

        assertNotNull(result);
        assertEquals("Juan", result.getNombre());
        verify(tritianosRepository, times(1)).findById(1L);
    }

    @Test
    void shouldReturnNullWhenTritianosByIdNotFound() {
        when(tritianosRepository.findById(1L)).thenReturn(Optional.empty());

        Tritianos result = adapter.getTritianosById(1L);

        assertNull(result);
        verify(tritianosRepository, times(1)).findById(1L);
    }

    @Test
    void shouldSaveTritianos() {
        Tritianos tritianos = new Tritianos(null, "Juan", "Perez", "juan.perez@example.com", "12345678-9", "+12345678901", "Activo", null, null, null, null, null);
        TritianosEntity savedEntity = new TritianosEntity(1L, "Juan", "Perez", "juan.perez@example.com", "12345678-9", "+12345678901", "Activo", null, null, null, null, null);

         when(tritianosRepository.save(any(TritianosEntity.class))).thenReturn(savedEntity);

        Tritianos result = adapter.saveTritianos(tritianos);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(tritianosRepository, times(1)).save(any(TritianosEntity.class));
    }

    @Test
    void shouldGetAllTritianos() {
        TritianosEntity entity1 = new TritianosEntity(1L, "Juan", "Perez", "juan.perez@example.com", "12345678-9", "+12345678901", "Activo", null, null, null, null, null);
        TritianosEntity entity2 = new TritianosEntity(2L, "Maria", "Gomez", "maria.gomez@example.com", "87654321-K", "+12345678902", "Inactivo", null, null, null, null, null);

        when(tritianosRepository.findAll()).thenReturn(Arrays.asList(entity1, entity2));

        List<Tritianos> result = adapter.getAllTritianos();

        assertEquals(2, result.size());
        verify(tritianosRepository, times(1)).findAll();
    }

    @Test
    void shouldDeleteTritianosById() {
        doNothing().when(tritianosRepository).deleteById(1L);

        adapter.deleteTritianoById(1L);

        verify(tritianosRepository, times(1)).deleteById(1L);
    }

    @Test
    void shouldUpdateTritianosById() {
        Tritianos tritianos = new Tritianos(null, "Juan Actualizado", "Perez", "juan.perez@example.com", "12345678-9", "+12345678901", "Activo", null, null, null, null, null);
        TritianosEntity existingEntity = new TritianosEntity(1L, "Juan", "Perez", "juan.perez@example.com", "12345678-9", "+12345678901", "Activo", null, null, null, null, null);
        TritianosEntity updatedEntity = new TritianosEntity(1L, "Juan Actualizado", "Perez", "juan.perez@example.com", "12345678-9", "+12345678901", "Activo", null, null, null, null, null);

        when(tritianosRepository.findById(1L)).thenReturn(Optional.of(existingEntity));
        when(tritianosRepository.save(existingEntity)).thenReturn(updatedEntity);

        Tritianos result = adapter.updateTritianoById(1L, tritianos);

        assertNotNull(result);
        assertEquals("Juan Actualizado", result.getNombre());
        verify(tritianosRepository, times(1)).findById(1L);
        verify(tritianosRepository, times(1)).save(existingEntity);
    }

}
