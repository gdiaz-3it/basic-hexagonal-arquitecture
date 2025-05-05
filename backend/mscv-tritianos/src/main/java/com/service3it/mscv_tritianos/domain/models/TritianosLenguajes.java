package com.service3it.mscv_tritianos.domain.models;

public class TritianosLenguajes {

    private final Long id;
    private final String rut;
    private final String nivel;

    public TritianosLenguajes(Long id, String rut, String nivel) {
        this.id = id;
        this.rut = rut;
        this.nivel = nivel;
    }

    public Long getId() {
        return id;
    }

    public String getRut() {
        return rut;
    }

    public String getNivel() {
        return nivel;
    }

}
