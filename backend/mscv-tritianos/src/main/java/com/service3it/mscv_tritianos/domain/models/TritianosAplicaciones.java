package com.service3it.mscv_tritianos.domain.models;

public class TritianosAplicaciones {

    private final Long id;
    private final String rut;
    private final String nivel;
    private final String aplicacion;
    private final Long clienteId;

    public TritianosAplicaciones(Long id, String rut, String nivel, String aplicacion, Long clienteId) {
        this.id = id;
        this.rut = rut;
        this.nivel = nivel;
        this.aplicacion = aplicacion;
        this.clienteId = clienteId;
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

    public String getAplicacion() {
        return aplicacion;
    }

    public Long getClienteId() {
        return clienteId;
    }

}
