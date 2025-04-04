package com.service3it.mscv_trinitianos.application.usecase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.service3it.mscv_trinitianos.domain.ports.out.TrinitianosRepositoryPort;

public class DeleteTrinitianosUseCaseImplTest {

    @Mock
    private TrinitianosRepositoryPort trinitianosRepositoryPort;

    @InjectMocks
    private DeleteTrinitianoByIdUseCaseImpl deleteTrinitianoByIdUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldDeleteTrinitianoById() {
        Long id = 1L;

        deleteTrinitianoByIdUseCase.deleteTrinitianoById(id);

        verify(trinitianosRepositoryPort, times(1)).deleteTrinitianoById(id);
    }

    @Test
    void shouldThrowExceptionWhenRepositoryFails() {

        Long id = 1L;
        doThrow(new RuntimeException("Database error")).when(trinitianosRepositoryPort).deleteTrinitianoById(id);

        RuntimeException exception = org.junit.jupiter.api.Assertions.assertThrows(
            RuntimeException.class,
            () -> deleteTrinitianoByIdUseCase.deleteTrinitianoById(id)
        );

        assertEquals("Database error", exception.getMessage());
        verify(trinitianosRepositoryPort, times(1)).deleteTrinitianoById(id);
    }
    
}
