package com.service3it.mscv_trinitianos.domain.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

public class TrinitianosTest {

    @Test
    void shouldCreateTrinitariosSuccessfully() {
        // Arrange
        Long id = 1L;
        String nombre = "Juan";
        String apellido = "Perez";
        String correoElectronico = "juan.perez@example.com";
        String rut = "12345678-9";
        String telefono = "+12345678901";
        String estado = "Activo";
        String enlaceBizneo = "https://bizneo.com/juan";
        String enlaceHubspot = "https://hubspot.com/juan";
        String enlaceJira = "https://jira.com/juan";
        LocalDateTime fechaCreacion = LocalDateTime.now();
        LocalDateTime fechaModificacion = LocalDateTime.now();

        // Act
        Trinitianos trinitarios = new Trinitianos(
            id, nombre, apellido, correoElectronico, rut, telefono, estado,
            enlaceBizneo, enlaceHubspot, enlaceJira, fechaCreacion, fechaModificacion
        );

        // Assert
        assertNotNull(trinitarios);
        assertEquals(id, trinitarios.getId());
        assertEquals(nombre, trinitarios.getNombre());
        assertEquals(apellido, trinitarios.getApellido());
        assertEquals(correoElectronico, trinitarios.getCorreoElectronico());
        assertEquals(rut, trinitarios.getRut());
        assertEquals(telefono, trinitarios.getTelefono());
        assertEquals(estado, trinitarios.getEstado());
        assertEquals(enlaceBizneo, trinitarios.getEnlaceBizneo());
        assertEquals(enlaceHubspot, trinitarios.getEnlaceHubspot());
        assertEquals(enlaceJira, trinitarios.getEnlaceJira());
        assertEquals(fechaCreacion, trinitarios.getFechaCreacion());
        assertEquals(fechaModificacion, trinitarios.getFechaModificacion());
    }

    @Test
    void shouldHandleNullValues() {
        // Act
        Trinitianos trinitarios = new Trinitianos(
            null, null, null, null, null, null, null,
            null, null, null, null, null
        );

        // Assert
        assertNotNull(trinitarios);
        assertNull(trinitarios.getId());
        assertNull(trinitarios.getNombre());
        assertNull(trinitarios.getApellido());
        assertNull(trinitarios.getCorreoElectronico());
        assertNull(trinitarios.getRut());
        assertNull(trinitarios.getTelefono());
        assertNull(trinitarios.getEstado());
        assertNull(trinitarios.getEnlaceBizneo());
        assertNull(trinitarios.getEnlaceHubspot());
        assertNull(trinitarios.getEnlaceJira());
        assertNull(trinitarios.getFechaCreacion());
        assertNull(trinitarios.getFechaModificacion());
    }

}
