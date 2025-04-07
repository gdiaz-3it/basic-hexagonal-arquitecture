package com.service3it.mscv_trinitianos.application.usecase;

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

import com.service3it.mscv_trinitianos.domain.models.Trinitianos;
import com.service3it.mscv_trinitianos.domain.ports.out.TrinitianosRepositoryPort;

public class GetTrinitianosByIdUseCaseImplTest {

    @Mock
    private TrinitianosRepositoryPort trinitianosRepositoryPort;

    @InjectMocks
    private GetTrinitianosByIdUseCaseImpl getTrinitianosByIdUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReturnTrinitariosWhenIdExists() {
        // Arrange
        Long id = 1L;
        Trinitianos mockTrinitarios = new Trinitianos(
            id, "Juan", "Perez", "juan.perez@example.com", "12345678-9", "+12345678901",
            "Activo", "https://bizneo.com/juan", "https://hubspot.com/juan", "https://jira.com/juan",
            null, null
        );
        when(trinitianosRepositoryPort.getTrinitianosById(id)).thenReturn(mockTrinitarios);

        // Act
        Trinitianos result = getTrinitianosByIdUseCase.getTrinitianosById(id);

        // Assert
        assertNotNull(result);
        assertEquals(mockTrinitarios, result);
        verify(trinitianosRepositoryPort, times(1)).getTrinitianosById(id);
    }

    @Test
    void shouldReturnNullWhenIdDoesNotExist() {
        // Arrange
        Long id = 1L;
        when(trinitianosRepositoryPort.getTrinitianosById(id)).thenReturn(null);

        // Act
        Trinitianos result = getTrinitianosByIdUseCase.getTrinitianosById(id);

        // Assert
        assertNull(result);
        verify(trinitianosRepositoryPort, times(1)).getTrinitianosById(id);
    }

}
