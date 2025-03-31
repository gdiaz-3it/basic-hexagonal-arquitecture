package com.service3it.mscv_trinitianos.domain.models;

import java.time.LocalDateTime;

public class Trinitianos {

    private final Long id;
    private final String nombre;
    private final String apellido;
    private final String correoElectronico;
    private final String telefono;
    private final String estado;
    private final String enlaceBizneo;
    private final String enlaceHubspot;
    private final String enlaceJira;
    private final LocalDateTime fechaCreacion;
    private final LocalDateTime fechaModificacion;

    public Trinitianos (Long id, String nombre, String apellido, String correoElectronico, String telefono, String estado, String enlaceBizneo, String enlaceHubspot, String enlaceJira, LocalDateTime fechaCreacion, LocalDateTime fechaModificacion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correoElectronico = correoElectronico;
        this.telefono = telefono;
        this.estado = estado;
        this.enlaceBizneo = enlaceBizneo;
        this.enlaceHubspot = enlaceHubspot;
        this.enlaceJira = enlaceJira;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEstado() {
        return estado;
    }

    public String getEnlaceBizneo() {
        return enlaceBizneo;
    }

    public String getEnlaceHubspot() {
        return enlaceHubspot;
    }

    public String getEnlaceJira() {
        return enlaceJira;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }

}
