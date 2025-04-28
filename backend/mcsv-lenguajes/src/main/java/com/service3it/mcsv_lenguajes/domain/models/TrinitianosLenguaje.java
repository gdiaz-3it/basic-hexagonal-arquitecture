package com.service3it.mcsv_lenguajes.domain.models;

public class TrinitianosLenguaje {

    private final Long id;
    private final Long trinitianoId;
    private final Long lenguajeId;
    private final String nivel;

    public TrinitianosLenguaje(Long id, Long trinitianoId, Long lenguajeId, String nivel) {
        this.id = id;
        this.trinitianoId = trinitianoId;
        this.lenguajeId = lenguajeId;
        this.nivel = nivel;
    }

    public Long getId() {
        return id;
    }

    public Long getTrinitianoId() {
        return trinitianoId;
    }

    public Long getLenguajeId() {
        return lenguajeId;
    }

    public String getNivel() {
        return nivel;
    }

}
