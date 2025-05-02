package com.service3it.mscv_tritianos.application.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
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

public class GetTritianosByIdUseCaseImplTest {

    @Mock
    private TritianosRepositoryPort tritianosRepositoryPort;

    @InjectMocks
    private GetTritianosByIdUseCaseImpl getTritianosByIdUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReturnTritianosWhenIdExists() {
        // Arrange
        Long id = 1L;
        Tritianos mockTritianos = new Tritianos(
            id, "Juan", "Perez", "juan.perez@example.com", "12345678-9", "+12345678901",
            "Activo", "https://bizneo.com/juan", "https://hubspot.com/juan", "https://jira.com/juan",
            null, null
        );
        when(tritianosRepositoryPort.getTritianosById(id)).thenReturn(mockTritianos);

        // Act
        Tritianos result = getTritianosByIdUseCase.getTritianosById(id);

        // Assert
        assertNotNull(result);
        assertEquals(mockTritianos, result);
        verify(tritianosRepositoryPort, times(1)).getTritianosById(id);
    }

    @Test
    void shouldReturnNullWhenIdDoesNotExist() {
        // Arrange
        Long id = 1L;
        when(tritianosRepositoryPort.getTritianosById(id)).thenReturn(null);

        // Act
        Tritianos result = getTritianosByIdUseCase.getTritianosById(id);

        // Assert
        assertNull(result);
        verify(tritianosRepositoryPort, times(1)).getTritianosById(id);
    }

}
