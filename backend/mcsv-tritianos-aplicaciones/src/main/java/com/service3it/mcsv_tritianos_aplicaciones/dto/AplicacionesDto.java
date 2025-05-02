package com.service3it.mcsv_tritianos_aplicaciones.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AplicacionesDto {

    private Long id;
    private String nombre;
    private String nivel;

}
