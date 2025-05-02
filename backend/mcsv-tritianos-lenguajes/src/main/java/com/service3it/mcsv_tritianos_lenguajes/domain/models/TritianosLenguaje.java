package com.service3it.mcsv_tritianos_lenguajes.domain.models;

public class TritianosLenguaje {

    private final Long id;
    private final String descripcion;

    public TritianosLenguaje(Long id, String descripcion) {
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
