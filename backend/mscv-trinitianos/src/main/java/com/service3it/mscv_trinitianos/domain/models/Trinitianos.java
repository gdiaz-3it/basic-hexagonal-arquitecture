package com.service3it.mscv_trinitianos.domain.models;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Trinitianos {

    private Long id;
    private String nombre;
    private String apellido;
    private String correo_electronico;
    private String telefono;
    private String estado;
    private String enlace_bizneo;
    private String enlace_hubspot;
    private String enlace_jira;
    private LocalDateTime fecha_creacion;

}
