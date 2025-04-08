package com.service3it.mscv_trinitianos.infraestructure.adapters.in.rest.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.service3it.mscv_trinitianos.domain.models.Trinitianos;
import com.service3it.mscv_trinitianos.domain.ports.in.*;
import com.service3it.mscv_trinitianos.infraestructure.adapters.in.rest.dto.TrinitianosDTO;

import jakarta.persistence.EntityNotFoundException;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

@WebMvcTest(TrinitianosController.class)
@Import(TrinitianosControllerUnitTest.MockConfig.class)
public class TrinitianosControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private GetAllTrinitianosUseCase getAllTrinitianos;

    @Autowired
    private GetTrinitianosByIdUseCase getTrinitianosById;

    @Autowired
    private SaveTrinitianosUseCase saveTrinitianos;

    @Autowired
    private DeleteTrinitianoByIdUseCase deleteTrinitianoById;

    @Autowired
    private UpdateTrinitianoByIdUseCase updateTrinitianoById;

    @TestConfiguration
    static class MockConfig {
        @Bean GetAllTrinitianosUseCase getAllTrinitianos() {
            return Mockito.mock(GetAllTrinitianosUseCase.class);
        }

        @Bean GetTrinitianosByIdUseCase getTrinitianosById() {
            return Mockito.mock(GetTrinitianosByIdUseCase.class);
        }

        @Bean SaveTrinitianosUseCase saveTrinitianos() {
            return Mockito.mock(SaveTrinitianosUseCase.class);
        }

        @Bean DeleteTrinitianoByIdUseCase deleteTrinitianoById() {
            return Mockito.mock(DeleteTrinitianoByIdUseCase.class);
        }

        @Bean UpdateTrinitianoByIdUseCase updateTrinitianoById() {
            return Mockito.mock(UpdateTrinitianoByIdUseCase.class);
        }
    }

    @Test
    void shouldReturnAllTrinitarios() throws Exception {

        List<Trinitianos> trinitariosList = Arrays.asList(
            new Trinitianos(1L, "Juan", "Perez", "juan.perez@example.com", "12345678-9", "+12345678901", "Activo", "https://bizneo.com/juan", "https://hubspot.com/juan", "https://jira.com/juan", null, null),
            new Trinitianos(2L, "Maria", "Gomez", "maria.gomez@example.com", "87654321-K", "+12345678902", "Inactivo", "https://bizneo.com/maria", "https://hubspot.com/maria", "https://jira.com/maria", null, null)
        );
        when(getAllTrinitianos.getAllTrinitianos()).thenReturn(trinitariosList);

        mockMvc.perform(get("/api/trinitianos"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.length()").value(2))
            .andExpect(jsonPath("$[0].nombre").value("Juan"))
            .andExpect(jsonPath("$[1].nombre").value("Maria"));
    }

    @Test
    void shouldReturnInternalServerErrorWhenExceptionThrownInGetAllTrinitarios() throws Exception {
        when(getAllTrinitianos.getAllTrinitianos()).thenThrow(new RuntimeException("Unexpected error"));

    mockMvc.perform(get("/api/trinitianos"))
        .andExpect(status().isInternalServerError());
    }

    @Test
    void shouldReturnTrinitariosById() throws Exception {

        Trinitianos trinitarios = new Trinitianos(1L, "Juan", "Perez", "juan.perez@example.com", "12345678-9", "+12345678901", "Activo", "https://bizneo.com/juan", "https://hubspot.com/juan", "https://jira.com/juan", null, null);
        when(getTrinitianosById.getTrinitianosById(1L)).thenReturn(trinitarios);


        mockMvc.perform(get("/api/trinitianos/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.nombre").value("Juan"))
            .andExpect(jsonPath("$.apellido").value("Perez"));
    }
    

    @Test
    void shouldReturnNotFoundWhenTrinitarioDoesNotExist() throws Exception {
        when(getTrinitianosById.getTrinitianosById(99L)).thenReturn(null);

        mockMvc.perform(get("/api/trinitianos/99"))
                .andExpect(status().isNotFound());
    }

    @Test
    void shouldSaveTrinitarios() throws Exception {

        TrinitianosDTO dto = new TrinitianosDTO(null, "Juan", "Perez", "juan.perez@example.com", "12345678-9", "+12345678901", "Activo", "https://bizneo.com/juan", "https://hubspot.com/juan", "https://jira.com/juan");
        Trinitianos savedTrinitarios = new Trinitianos(1L, "Juan", "Perez", "juan.perez@example.com", "12345678-9", "+12345678901", "Activo", "https://bizneo.com/juan", "https://hubspot.com/juan", "https://jira.com/juan", null, null);
        when(saveTrinitianos.saveTrinitianos(any(Trinitianos.class))).thenReturn(savedTrinitarios);

        mockMvc.perform(post("/api/trinitianos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.id").value(1))
            .andExpect(jsonPath("$.nombre").value("Juan"));
    }

    @Test
    void shouldDeleteTrinitariosById() throws Exception {

        mockMvc.perform(delete("/api/trinitianos/1"))
            .andExpect(status().isNoContent());
        verify(deleteTrinitianoById, times(1)).deleteTrinitianoById(1L);
    }

    @Test
    void shouldReturnInternalServerErrorWhenExceptionThrownInDeleteTrinitariosById() throws Exception {

        doThrow(new RuntimeException("Unexpected error")).when(deleteTrinitianoById).deleteTrinitianoById(2L);

        mockMvc.perform(delete("/api/trinitianos/2"))
            .andExpect(status().isInternalServerError());
    }

    @Test
    void shouldUpdateTrinitariosById() throws Exception {

        Long id = 1L;
        TrinitianosDTO dto = new TrinitianosDTO(
            null, "Juan Actualizado", "Perez Actualizado", "juan.actualizado@example.com", 
            "12345678-9", "+12345678901", "Activo", 
            "https://bizneo.com/juan_actualizado", "https://hubspot.com/juan_actualizado", 
            "https://jira.com/juan_actualizado"
        );
    
        Trinitianos updatedTrinitarios = new Trinitianos(
            id, "Juan Actualizado", "Perez Actualizado", "juan.actualizado@example.com", 
            "12345678-9", "+12345678901", "Activo", 
            "https://bizneo.com/juan_actualizado", "https://hubspot.com/juan_actualizado", 
            "https://jira.com/juan_actualizado", null, null
        );

        when(updateTrinitianoById.updateTrinitianoById(eq(id), any(Trinitianos.class))).thenReturn(updatedTrinitarios);

        mockMvc.perform(patch("/api/trinitianos/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(1))
            .andExpect(jsonPath("$.nombre").value("Juan Actualizado"))
            .andExpect(jsonPath("$.apellido").value("Perez Actualizado"))
            .andExpect(jsonPath("$.correoElectronico").value("juan.actualizado@example.com"))
            .andExpect(jsonPath("$.enlaceBizneo").value("https://bizneo.com/juan_actualizado"));
    }

    @Test
    void shouldReturnNotFoundWhenTrinitarioDoesNotExistInUpdate() throws Exception {
        Long id = 1L;
        TrinitianosDTO dto = new TrinitianosDTO(
            null, "Juan Actualizado", "Perez Actualizado", "juan.actualizado@example.com", 
            "12345678-9", "+12345678901", "Activo", 
            "https://bizneo.com/juan_actualizado", "https://hubspot.com/juan_actualizado", 
            "https://jira.com/juan_actualizado"
        );

        // Simula que el caso de uso lanza EntityNotFoundException
        when(updateTrinitianoById.updateTrinitianoById(eq(id), any(Trinitianos.class)))
            .thenThrow(new EntityNotFoundException("Trinitario not found"));

        mockMvc.perform(patch("/api/trinitianos/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
            .andExpect(status().isNotFound());
    }

}
