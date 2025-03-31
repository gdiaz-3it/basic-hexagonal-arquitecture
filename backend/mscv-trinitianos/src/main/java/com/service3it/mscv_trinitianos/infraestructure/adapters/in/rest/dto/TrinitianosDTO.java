package com.service3it.mscv_trinitianos.infraestructure.adapters.in.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrinitianosDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private String correoElectronico;
    private String telefono;
    private String estado;
    private String enlaceBizneo;
    private String enlaceHubspot;
    private String enlaceJira;

}
