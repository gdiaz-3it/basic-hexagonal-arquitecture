package com.service3it.mscv_tritianos.application.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.service3it.mscv_tritianos.domain.models.Tritianos;
import com.service3it.mscv_tritianos.domain.ports.out.TritianosRepositoryPort;

public class GetAllTritianosUseCaseImplTest {

    @Mock
    private TritianosRepositoryPort tritianosRepositoryPort;

    @InjectMocks
    private GetAllTritianosUseCaseImpl getAllTritianosUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReturnAllTritianos() {
        List<Tritianos> mockTritianos = Arrays.asList(
            new Tritianos(1L, "Juan", "Perez", "juan.perez@example.com", "12345678-9", "+12345678901", "Activo", null, null, null, null, null),
            new Tritianos(2L, "Maria", "Gomez", "maria.gomez@example.com", "87654321-K", "+12345678902", "Inactivo", null, null, null, null, null)
        );
        when(tritianosRepositoryPort.getAllTritianos()).thenReturn(mockTritianos);

        List<Tritianos> result = getAllTritianosUseCase.getAllTritianos();

        assertEquals(mockTritianos.size(), result.size());
        assertEquals(mockTritianos, result);
        verify(tritianosRepositoryPort, times(1)).getAllTritianos();
    }

    @Test
    void shouldReturnEmptyListWhenNoTrinitariosFound() {
        when(tritianosRepositoryPort.getAllTritianos()).thenReturn(List.of());

        List<Tritianos> result = getAllTritianosUseCase.getAllTritianos();
        
        assertEquals(0, result.size());
        verify(tritianosRepositoryPort, times(1)).getAllTritianos();
    }
}
