package com.service3it.mscv_trinitianos.application.usecase;

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

import com.service3it.mscv_trinitianos.domain.models.Trinitianos;
import com.service3it.mscv_trinitianos.domain.ports.out.TrinitianosRepositoryPort;

public class SaveTrinitianosUseCaseImplTest {

    @Mock
    private TrinitianosRepositoryPort trinitianosRepositoryPort;

    @InjectMocks
    private SaveTrinitianosUseCaseImpl saveTrinitianosUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldSaveTrinitariosSuccessfully() {
        // Arrange
        Trinitianos trinitianosToSave = new Trinitianos(
            null, "Juan", "Perez", "juan.perez@example.com", "12345678-9", "+12345678901",
            "Activo", "https://bizneo.com/juan", "https://hubspot.com/juan", "https://jira.com/juan",
            null, null
        );
        Trinitianos savedTrinitarios = new Trinitianos(
            1L, "Juan", "Perez", "juan.perez@example.com", "12345678-9", "+12345678901",
            "Activo", "https://bizneo.com/juan", "https://hubspot.com/juan", "https://jira.com/juan",
            null, null
        );
        when(trinitianosRepositoryPort.saveTrinitianos(trinitianosToSave)).thenReturn(savedTrinitarios);

        // Act
        Trinitianos result = saveTrinitianosUseCase.saveTrinitianos(trinitianosToSave);

        // Assert
        assertNotNull(result);
        assertEquals(savedTrinitarios, result);
        verify(trinitianosRepositoryPort, times(1)).saveTrinitianos(trinitianosToSave);
    }

    @Test
    void shouldThrowExceptionWhenRepositoryFails() {
        // Arrange
        Trinitianos trinitianosToSave = new Trinitianos(
            null, "Juan", "Perez", "juan.perez@example.com", "12345678-9", "+12345678901",
            "Activo", "https://bizneo.com/juan", "https://hubspot.com/juan", "https://jira.com/juan",
            null, null
        );
        doThrow(new RuntimeException("Database error")).when(trinitianosRepositoryPort).saveTrinitianos(trinitianosToSave);

        // Act & Assert
        RuntimeException exception = assertThrows(
            RuntimeException.class,
            () -> saveTrinitianosUseCase.saveTrinitianos(trinitianosToSave)
        );

        assertEquals("Database error", exception.getMessage());
        verify(trinitianosRepositoryPort, times(1)).saveTrinitianos(trinitianosToSave);
    }

}
