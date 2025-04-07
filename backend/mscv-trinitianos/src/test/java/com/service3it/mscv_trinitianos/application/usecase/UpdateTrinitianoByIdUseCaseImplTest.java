package com.service3it.mscv_trinitianos.application.usecase;

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

import com.service3it.mscv_trinitianos.domain.models.Trinitianos;
import com.service3it.mscv_trinitianos.domain.ports.out.TrinitianosRepositoryPort;

public class UpdateTrinitianoByIdUseCaseImplTest {

    @Mock
    private TrinitianosRepositoryPort trinitianosRepositoryPort;

    @InjectMocks
    private UpdateTrinitianoByIdUseCaseImpl updateTrinitianoByIdUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldUpdateTrinitianoWhenIdExists() {
        // Arrange
        Long id = 1L;
        Trinitianos updatedTrinitianos = new Trinitianos(
            id, "Juan", "Perez", "juan.perez@example.com", "12345678-9", "+12345678901",
            "Activo", "https://bizneo.com/juan", "https://hubspot.com/juan", "https://jira.com/juan",
            null, null
        );
        when(trinitianosRepositoryPort.updateTrinitianoById(eq(id), any(Trinitianos.class))).thenReturn(updatedTrinitianos);

        // Act
        Trinitianos result = updateTrinitianoByIdUseCase.updateTrinitianoById(id, updatedTrinitianos);

        // Assert
        assertNotNull(result);
        assertEquals(updatedTrinitianos, result);
        verify(trinitianosRepositoryPort, times(1)).updateTrinitianoById(id, updatedTrinitianos);
    }

    @Test
    void shouldReturnNullWhenIdDoesNotExist() {
        // Arrange
        Long id = 1L;
        Trinitianos trinitianosToUpdate = new Trinitianos(
            id, "Juan", "Perez", "juan.perez@example.com", "12345678-9", "+12345678901",
            "Activo", "https://bizneo.com/juan", "https://hubspot.com/juan", "https://jira.com/juan",
            null, null
        );
        when(trinitianosRepositoryPort.updateTrinitianoById(eq(id), any(Trinitianos.class))).thenReturn(null);

        // Act
        Trinitianos result = updateTrinitianoByIdUseCase.updateTrinitianoById(id, trinitianosToUpdate);

        // Assert
        assertNull(result);
        verify(trinitianosRepositoryPort, times(1)).updateTrinitianoById(id, trinitianosToUpdate);
    }

    @Test
    void shouldThrowExceptionWhenRepositoryFails() {
        // Arrange
        Long id = 1L;
        Trinitianos trinitianosToUpdate = new Trinitianos(
            id, "Juan", "Perez", "juan.perez@example.com", "12345678-9", "+12345678901",
            "Activo", "https://bizneo.com/juan", "https://hubspot.com/juan", "https://jira.com/juan",
            null, null
        );
        doThrow(new RuntimeException("Database error")).when(trinitianosRepositoryPort).updateTrinitianoById(eq(id), any(Trinitianos.class));

        // Act & Assert
        RuntimeException exception = assertThrows(
            RuntimeException.class,
            () -> updateTrinitianoByIdUseCase.updateTrinitianoById(id, trinitianosToUpdate)
        );

        assertEquals("Database error", exception.getMessage());
        verify(trinitianosRepositoryPort, times(1)).updateTrinitianoById(id, trinitianosToUpdate);
    }

}
