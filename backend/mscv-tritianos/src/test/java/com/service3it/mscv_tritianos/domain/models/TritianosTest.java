package com.service3it.mscv_tritianos.domain.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

public class TritianosTest {

    @Test
    void shouldCreateTritianosSuccessfully() {

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

        Tritianos tritianos = new Tritianos(
            id, nombre, apellido, correoElectronico, rut, telefono, estado,
            enlaceBizneo, enlaceHubspot, enlaceJira, fechaCreacion, fechaModificacion
        );

        assertNotNull(tritianos);
        assertEquals(id, tritianos.getId());
        assertEquals(nombre, tritianos.getNombre());
        assertEquals(apellido, tritianos.getApellido());
        assertEquals(correoElectronico, tritianos.getCorreoElectronico());
        assertEquals(rut, tritianos.getRut());
        assertEquals(telefono, tritianos.getTelefono());
        assertEquals(estado, tritianos.getEstado());
        assertEquals(enlaceBizneo, tritianos.getEnlaceBizneo());
        assertEquals(enlaceHubspot, tritianos.getEnlaceHubspot());
        assertEquals(enlaceJira, tritianos.getEnlaceJira());
        assertEquals(fechaCreacion, tritianos.getFechaCreacion());
        assertEquals(fechaModificacion, tritianos.getFechaModificacion());
    }

    @Test
    void shouldHandleNullValues() {
        // Act
        Tritianos tritianos = new Tritianos(
            null, null, null, null, null, null, null,
            null, null, null, null, null
        );

        // Assert
        assertNotNull(tritianos);
        assertNull(tritianos.getId());
        assertNull(tritianos.getNombre());
        assertNull(tritianos.getApellido());
        assertNull(tritianos.getCorreoElectronico());
        assertNull(tritianos.getRut());
        assertNull(tritianos.getTelefono());
        assertNull(tritianos.getEstado());
        assertNull(tritianos.getEnlaceBizneo());
        assertNull(tritianos.getEnlaceHubspot());
        assertNull(tritianos.getEnlaceJira());
        assertNull(tritianos.getFechaCreacion());
        assertNull(tritianos.getFechaModificacion());
    }

}
