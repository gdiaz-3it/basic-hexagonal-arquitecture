package com.service3it.mcsv_lenguajes.domain.models;

public class TrinitianosLenguaje {

    private final Long id;
    private final Long lenguajeId;
    private final String nivel;

    public TrinitianosLenguaje(Long id, Long lenguajeId, String nivel) {
        this.id = id;
        this.lenguajeId = lenguajeId;
        this.nivel = nivel;
    }

    public Long getId() {
        return id;
    }

    public Long getLenguajeId() {
        return lenguajeId;
    }

    public String getNivel() {
        return nivel;
    }

}
