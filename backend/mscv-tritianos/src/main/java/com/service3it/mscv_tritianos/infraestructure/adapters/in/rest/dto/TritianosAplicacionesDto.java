package com.service3it.mscv_tritianos.infraestructure.adapters.in.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TritianosAplicacionesDto {

    private Long id;
    private String nivel;
    private String aplicacion;

}
