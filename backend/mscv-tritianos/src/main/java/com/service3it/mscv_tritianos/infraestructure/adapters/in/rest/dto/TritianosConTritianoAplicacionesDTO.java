package com.service3it.mscv_tritianos.infraestructure.adapters.in.rest.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TritianosConTritianoAplicacionesDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private String rut;
    private String telefono;
    private String estado;
    private String enlaceBizneo;
    private String enlaceHubspot;
    private String enlaceJira;
    private List<TritianosAplicacionesDto> aplicaciones;

}
