package com.service3it.mscv_trinitianos.domain.models;

import java.time.LocalDateTime;

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

    public Trinitianos (Long id, String nombre, String apellido, String correo_electronico, String telefono, String estado, String enlace_bizneo, String enlace_hubspot, String enlace_jira, LocalDateTime fecha_creacion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo_electronico = correo_electronico;
        this.telefono = telefono;
        this.estado = estado;
        this.enlace_bizneo = enlace_bizneo;
        this.enlace_hubspot = enlace_hubspot;
        this.enlace_jira = enlace_jira;
        this.fecha_creacion = fecha_creacion;
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

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEstado() {
        return estado;
    }

    public String getEnlace_bizneo() {
        return enlace_bizneo;
    }

    public String getEnlace_hubspot() {
        return enlace_hubspot;
    }

    public String getEnlace_jira() {
        return enlace_jira;
    }

    public LocalDateTime getFecha_creacion() {
        return fecha_creacion;
    }

}
