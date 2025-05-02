package com.service3it.mscv_tritianos.application.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.service3it.mscv_tritianos.domain.ports.in.DeleteTritianoByIdUseCase;
import com.service3it.mscv_tritianos.domain.ports.out.TritianosRepositoryPort;

public class DeleteTritianosUseCaseImplTest {

    @Mock
    private TritianosRepositoryPort tritianosRepositoryPort;

    @InjectMocks
    private DeleteTritianoByIdUseCase deleteTritianoByIdUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldDeletetriTianoById() {
        Long id = 1L;

        deleteTritianoByIdUseCase.deleteTritianoById(id);

        verify(tritianosRepositoryPort, times(1)).deleteTritianoById(id);
    }

    @Test
    void shouldThrowExceptionWhenRepositoryFails() {

        Long id = 1L;
        doThrow(new RuntimeException("Database error")).when(tritianosRepositoryPort).deleteTritianoById(id);

        RuntimeException exception = org.junit.jupiter.api.Assertions.assertThrows(
            RuntimeException.class,
            () -> deleteTritianoByIdUseCase.deleteTritianoById(id)
        );

        assertEquals("Database error", exception.getMessage());
        verify(tritianosRepositoryPort, times(1)).deleteTritianoById(id);
    }
    
}
