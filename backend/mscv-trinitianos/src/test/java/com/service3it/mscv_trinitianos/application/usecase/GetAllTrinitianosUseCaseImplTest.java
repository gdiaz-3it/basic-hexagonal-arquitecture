package com.service3it.mscv_trinitianos.application.usecase;

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

import com.service3it.mscv_trinitianos.domain.models.Trinitianos;
import com.service3it.mscv_trinitianos.domain.ports.out.TrinitianosRepositoryPort;

public class GetAllTrinitianosUseCaseImplTest {

    @Mock
    private TrinitianosRepositoryPort trinitianosRepositoryPort;

    @InjectMocks
    private GetAllTrinitianosUseCaseImpl getAllTrinitianosUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReturnAllTrinitarios() {
        List<Trinitianos> mockTrinitarios = Arrays.asList(
            new Trinitianos(1L, "Juan", "Perez", "juan.perez@example.com", "12345678-9", "+12345678901", "Activo", null, null, null, null, null),
            new Trinitianos(2L, "Maria", "Gomez", "maria.gomez@example.com", "87654321-K", "+12345678902", "Inactivo", null, null, null, null, null)
        );
        when(trinitianosRepositoryPort.getAllTrinitianos()).thenReturn(mockTrinitarios);

        List<Trinitianos> result = getAllTrinitianosUseCase.getAllTrinitianos();

        assertEquals(mockTrinitarios.size(), result.size());
        assertEquals(mockTrinitarios, result);
        verify(trinitianosRepositoryPort, times(1)).getAllTrinitianos();
    }

    @Test
    void shouldReturnEmptyListWhenNoTrinitariosFound() {
        when(trinitianosRepositoryPort.getAllTrinitianos()).thenReturn(List.of());

        List<Trinitianos> result = getAllTrinitianosUseCase.getAllTrinitianos();
        
        assertEquals(0, result.size());
        verify(trinitianosRepositoryPort, times(1)).getAllTrinitianos();
    }
}
