package com.service3it.mcsv_tinitianos_lenguajes.domain.models;

public class Lenguajes {

    private final Long id;
    private final String nombre;
    private final String nivel;

    public Lenguajes(Long id, String nombre, String nivel) {
        this.id = id;
        this.nombre = nombre;
        this.nivel = nivel;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNivel() {
        return nivel;
    }

}
