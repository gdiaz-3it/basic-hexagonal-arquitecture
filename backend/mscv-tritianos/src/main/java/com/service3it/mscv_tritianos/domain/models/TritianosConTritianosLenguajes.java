package com.service3it.mscv_tritianos.domain.models;

import java.util.List;

public class TritianosConTritianosLenguajes {

    private final Long id;
    private final String nombre;
    private final String apellido;
    private final String correoElectronico;
    private final String rut;
    private final String telefono;
    private final String estado;
    private final String enlaceBizneo;
    private final String enlaceHubspot;
    private final String enlaceJira;
    private final List<TritianosLenguajes> lenguajes;

    public TritianosConTritianosLenguajes(Long id, String nombre, String apellido, String correoElectronico, String rut, String telefono,
            String estado, String enlaceBizneo, String enlaceHubspot, String enlaceJira,
            List<TritianosLenguajes> lenguajes) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correoElectronico = correoElectronico;
        this.rut = rut;
        this.telefono = telefono;
        this.estado = estado;
        this.enlaceBizneo = enlaceBizneo;
        this.enlaceHubspot = enlaceHubspot;
        this.enlaceJira = enlaceJira;
        this.lenguajes = lenguajes;
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

    public String getRut() {
        return rut;
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

    public List<TritianosLenguajes> getLenguajes() {
        return lenguajes;
    }

}
