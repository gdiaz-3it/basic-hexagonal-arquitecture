package com.service3it.mscv_tritianos.application.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.service3it.mscv_tritianos.domain.models.Tritianos;
import com.service3it.mscv_tritianos.domain.ports.out.TritianosRepositoryPort;

public class UpdateTritianoByIdUseCaseImplTest {

    @Mock
    private TritianosRepositoryPort tritianosRepositoryPort;

    @InjectMocks
    private UpdateTritianoByIdUseCaseImpl updateTritianoByIdUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldUpdatetritianoWhenIdExists() {
        // Arrange
        Long id = 1L;
        Tritianos updatedTritianos = new Tritianos(
            id, "Juan", "Perez", "juan.perez@example.com", "12345678-9", "+12345678901",
            "Activo", "https://bizneo.com/juan", "https://hubspot.com/juan", "https://jira.com/juan",
            null, null
        );
        when(tritianosRepositoryPort.updateTritianoById(eq(id), any(Tritianos.class))).thenReturn(updatedTritianos);

        // Act
        Tritianos result = updateTritianoByIdUseCase.updateTritianoById(id, updatedTritianos);

        // Assert
        assertNotNull(result);
        assertEquals(updatedTritianos, result);
        verify(tritianosRepositoryPort, times(1)).updateTritianoById(id, updatedTritianos);
    }

    @Test
    void shouldReturnNullWhenIdDoesNotExist() {
        // Arrange
        Long id = 1L;
        Tritianos tritianosToUpdate = new Tritianos(
            id, "Juan", "Perez", "juan.perez@example.com", "12345678-9", "+12345678901",
            "Activo", "https://bizneo.com/juan", "https://hubspot.com/juan", "https://jira.com/juan",
            null, null
        );
        when(tritianosRepositoryPort.updateTritianoById(eq(id), any(Tritianos.class))).thenReturn(null);

        // Act
        Tritianos result = updateTritianoByIdUseCase.updateTritianoById(id, tritianosToUpdate);

        // Assert
        assertNull(result);
        verify(tritianosRepositoryPort, times(1)).updateTritianoById(id, tritianosToUpdate);
    }

    @Test
    void shouldThrowExceptionWhenRepositoryFails() {
        // Arrange
        Long id = 1L;
        Tritianos tritianosToUpdate = new Tritianos(
            id, "Juan", "Perez", "juan.perez@example.com", "12345678-9", "+12345678901",
            "Activo", "https://bizneo.com/juan", "https://hubspot.com/juan", "https://jira.com/juan",
            null, null
        );
        doThrow(new RuntimeException("Database error")).when(tritianosRepositoryPort).updateTritianoById(eq(id), any(Tritianos.class));

        // Act & Assert
        RuntimeException exception = assertThrows(
            RuntimeException.class,
            () -> updateTritianoByIdUseCase.updateTritianoById(id, tritianosToUpdate)
        );

        assertEquals("Database error", exception.getMessage());
        verify(tritianosRepositoryPort, times(1)).updateTritianoById(id, tritianosToUpdate);
    }

}
