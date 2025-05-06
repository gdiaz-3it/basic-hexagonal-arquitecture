package com.service3it.mscv_tritianos.infraestructure.adapters.in.rest.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.service3it.mscv_tritianos.domain.models.Tritianos;
import com.service3it.mscv_tritianos.domain.ports.in.DeleteTritianoByIdUseCase;
import com.service3it.mscv_tritianos.domain.ports.in.GetAllTritianosUseCase;
import com.service3it.mscv_tritianos.domain.ports.in.GetTritianosByIdUseCase;
import com.service3it.mscv_tritianos.domain.ports.in.GetTritianosWithTritianoAplicacionByIdUseCase;
import com.service3it.mscv_tritianos.domain.ports.in.GetTritianosWithTritianoLenguajesByIdUseCase;
import com.service3it.mscv_tritianos.domain.ports.in.SaveTritianosUseCase;
import com.service3it.mscv_tritianos.domain.ports.in.UpdateTritianoByIdUseCase;
import com.service3it.mscv_tritianos.infraestructure.adapters.in.rest.dto.TritianosDTO;

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

@WebMvcTest(TritianosController.class)
@Import(TritianosControllerTest.MockConfig.class)
public class TritianosControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private GetAllTritianosUseCase getAllTritianos;

    @Autowired
    private GetTritianosByIdUseCase getTritianosById;

    @Autowired
    private SaveTritianosUseCase saveTritianos;

    @Autowired
    private DeleteTritianoByIdUseCase deleteTritianoById;

    @Autowired
    private UpdateTritianoByIdUseCase updateTritianoById;

    @TestConfiguration
    static class MockConfig {
        @Bean
        GetAllTritianosUseCase getAllTritianos() {
            return Mockito.mock(GetAllTritianosUseCase.class);
        }

        @Bean
        GetTritianosByIdUseCase getTritianosById() {
            return Mockito.mock(GetTritianosByIdUseCase.class);
        }

        @Bean
        SaveTritianosUseCase saveTritianos() {
            return Mockito.mock(SaveTritianosUseCase.class);
        }

        @Bean
        DeleteTritianoByIdUseCase deleteTritianoById() {
            return Mockito.mock(DeleteTritianoByIdUseCase.class);
        }

        @Bean
        UpdateTritianoByIdUseCase updateTritianoById() {
            return Mockito.mock(UpdateTritianoByIdUseCase.class);
        }

        @Bean
        GetTritianosWithTritianoAplicacionByIdUseCase getTritianosWithTritianoAplicacionesByIdUseCase() {
            return Mockito.mock(GetTritianosWithTritianoAplicacionByIdUseCase.class);
        }

        @Bean
        GetTritianosWithTritianoLenguajesByIdUseCase getTritianosWithTritianoLenguajesByIdUseCase() {
            return Mockito.mock(GetTritianosWithTritianoLenguajesByIdUseCase.class);
        }
    }

    @Test
    void shouldReturnAllTritianos() throws Exception {

        List<Tritianos> tritianosList = Arrays.asList(
            new Tritianos(1L, "Juan", "Perez", "juan.perez@example.com", "12345678-9", "+12345678901", "Activo", "https://bizneo.com/juan", "https://hubspot.com/juan", "https://jira.com/juan", null, null),
            new Tritianos(2L, "Maria", "Gomez", "maria.gomez@example.com", "87654321-K", "+12345678902", "Inactivo", "https://bizneo.com/maria", "https://hubspot.com/maria", "https://jira.com/maria", null, null)
        );
        when(getAllTritianos.getAllTritianos()).thenReturn(tritianosList);

        mockMvc.perform(get("/api/tritianos"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.length()").value(2))
            .andExpect(jsonPath("$[0].nombre").value("Juan"))
            .andExpect(jsonPath("$[1].nombre").value("Maria"));
    }

    @Test
    void shouldReturnInternalServerErrorWhenExceptionThrownInGetAllTritianos() throws Exception {
        when(getAllTritianos.getAllTritianos()).thenThrow(new RuntimeException("Unexpected error"));

    mockMvc.perform(get("/api/tritianos"))
        .andExpect(status().isInternalServerError());
    }

    @Test
    void shouldReturnTritinosById() throws Exception {

        Tritianos tritianos = new Tritianos(1L, "Juan", "Perez", "juan.perez@example.com", "12345678-9", "+12345678901", "Activo", "https://bizneo.com/juan", "https://hubspot.com/juan", "https://jira.com/juan", null, null);
        when(getTritianosById.getTritianosById(1L)).thenReturn(tritianos);


        mockMvc.perform(get("/api/tritianos/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.nombre").value("Juan"))
            .andExpect(jsonPath("$.apellido").value("Perez"));
    }
    

    @Test
    void shouldReturnNotFoundWhenTritianoDoesNotExist() throws Exception {
        when(getTritianosById.getTritianosById(99L)).thenReturn(null);

        mockMvc.perform(get("/api/tritianos/99"))
                .andExpect(status().isNotFound());
    }

    @Test
    void shouldSaveTritianos() throws Exception {

        TritianosDTO dto = new TritianosDTO(null, "Juan", "Perez", "juan.perez@example.com", "12345678-9", "+12345678901", "Activo", "https://bizneo.com/juan", "https://hubspot.com/juan", "https://jira.com/juan");
        Tritianos savedTrinitarios = new Tritianos(1L, "Juan", "Perez", "juan.perez@example.com", "12345678-9", "+12345678901", "Activo", "https://bizneo.com/juan", "https://hubspot.com/juan", "https://jira.com/juan", null, null);
        when(saveTritianos.saveTritianos(any(Tritianos.class))).thenReturn(savedTrinitarios);

        mockMvc.perform(post("/api/tritianos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.id").value(1))
            .andExpect(jsonPath("$.nombre").value("Juan"));
    }

    @Test
    void shouldDeleteTritianosById() throws Exception {

        mockMvc.perform(delete("/api/tritianos/1"))
            .andExpect(status().isNoContent());
        verify(deleteTritianoById, times(1)).deleteTritianoById(1L);
    }

    @Test
    void shouldReturnInternalServerErrorWhenExceptionThrownInDeleteTritianosById() throws Exception {

        doThrow(new RuntimeException("Unexpected error")).when(deleteTritianoById).deleteTritianoById(2L);

        mockMvc.perform(delete("/api/tritianos/2"))
            .andExpect(status().isInternalServerError());
    }

    @Test
    void shouldUpdateTritianosById() throws Exception {

        Long id = 1L;
        TritianosDTO dto = new TritianosDTO(
            null, "Juan Actualizado", "Perez Actualizado", "juan.actualizado@example.com", 
            "12345678-9", "+12345678901", "Activo", 
            "https://bizneo.com/juan_actualizado", "https://hubspot.com/juan_actualizado", 
            "https://jira.com/juan_actualizado"
        );
    
        Tritianos updatedTrinitarios = new Tritianos(
            id, "Juan Actualizado", "Perez Actualizado", "juan.actualizado@example.com", 
            "12345678-9", "+12345678901", "Activo", 
            "https://bizneo.com/juan_actualizado", "https://hubspot.com/juan_actualizado", 
            "https://jira.com/juan_actualizado", null, null
        );

        when(updateTritianoById.updateTritianoById(eq(id), any( Tritianos.class))).thenReturn(updatedTrinitarios);

        mockMvc.perform(patch("/api/tritianos/{id}", id)
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
    void shouldReturnNotFoundWhenTritianoDoesNotExistInUpdate() throws Exception {
        Long id = 1L;
        TritianosDTO dto = new TritianosDTO(
            null, "Juan Actualizado", "Perez Actualizado", "juan.actualizado@example.com", 
            "12345678-9", "+12345678901", "Activo", 
            "https://bizneo.com/juan_actualizado", "https://hubspot.com/juan_actualizado", 
            "https://jira.com/juan_actualizado"
        );

        // Simula que el caso de uso lanza EntityNotFoundException
        when(updateTritianoById.updateTritianoById(eq(id), any(Tritianos.class)))
            .thenThrow(new EntityNotFoundException("Trinitario not found"));

        mockMvc.perform(patch("/api/tritianos/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
            .andExpect(status().isNotFound());
    }

}
