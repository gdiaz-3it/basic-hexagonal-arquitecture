package com.service3it.mscv_tritianos.application.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
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

public class SaveTritianosUseCaseImplTest {

    @Mock
    private TritianosRepositoryPort tritianosRepositoryPort;

    @InjectMocks
    private SaveTritianosUseCaseImpl saveTritianosUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldSaveTritianosSuccessfully() {
        // Arrange
        Tritianos tritianosToSave = new Tritianos(
            null, "Juan", "Perez", "juan.perez@example.com", "12345678-9", "+12345678901",
            "Activo", "https://bizneo.com/juan", "https://hubspot.com/juan", "https://jira.com/juan",
            null, null
        );
        Tritianos savedTritianos = new Tritianos(
            1L, "Juan", "Perez", "juan.perez@example.com", "12345678-9", "+12345678901",
            "Activo", "https://bizneo.com/juan", "https://hubspot.com/juan", "https://jira.com/juan",
            null, null
        );
        when(tritianosRepositoryPort.saveTritianos(tritianosToSave)).thenReturn(savedTritianos);

        // Act
        Tritianos result = saveTritianosUseCase.saveTritianos(tritianosToSave);

        // Assert
        assertNotNull(result);
        assertEquals(savedTritianos, result);
        verify(tritianosRepositoryPort, times(1)).saveTritianos(tritianosToSave);
    }

    @Test
    void shouldThrowExceptionWhenRepositoryFails() {
        // Arrange
        Tritianos tritianosToSave = new Tritianos(
            null, "Juan", "Perez", "juan.perez@example.com", "12345678-9", "+12345678901",
            "Activo", "https://bizneo.com/juan", "https://hubspot.com/juan", "https://jira.com/juan",
            null, null
        );
        doThrow(new RuntimeException("Database error")).when(tritianosRepositoryPort).saveTritianos(tritianosToSave);

        // Act & Assert
        RuntimeException exception = assertThrows(
            RuntimeException.class,
            () -> saveTritianosUseCase.saveTritianos(tritianosToSave)
        );

        assertEquals("Database error", exception.getMessage());
        verify(tritianosRepositoryPort, times(1)).saveTritianos(tritianosToSave);
    }

}
