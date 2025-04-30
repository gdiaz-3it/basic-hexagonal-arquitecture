package com.service3it.mcsv_tinitianos_lenguajes.domain.models;

public class TrinitianosLenguaje {

    private final Long id;
    private final String descripcion;

    public TrinitianosLenguaje(Long id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

}
