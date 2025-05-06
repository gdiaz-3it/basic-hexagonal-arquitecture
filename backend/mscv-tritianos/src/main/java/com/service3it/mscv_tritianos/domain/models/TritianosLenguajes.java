package com.service3it.mscv_tritianos.domain.models;

public class TritianosLenguajes {

    private final Long id;
    private final String nivel;
    private final String lenguaje;
    private final Long clienteId;

    public TritianosLenguajes(Long id, String nivel, String lenguaje, Long clienteId) {
        this.id = id;
        this.nivel = nivel;
        this.lenguaje = lenguaje;
        this.clienteId = clienteId;
    }

    public Long getId() {
        return id;
    }

    public String getNivel() {
        return nivel;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public Long getClienteId() {
        return clienteId;
    }

}
