package com.service3it.mscv_trinitianos.infraestructure.adapters.in.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrinitianosAplicacionesDto {

    private Long id;
    private String rut;
    private String nivel;

}
