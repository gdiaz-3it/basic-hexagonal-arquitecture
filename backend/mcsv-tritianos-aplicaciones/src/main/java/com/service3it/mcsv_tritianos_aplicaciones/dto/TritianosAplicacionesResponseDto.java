package com.service3it.mcsv_tritianos_aplicaciones.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TritianosAplicacionesResponseDto {

    private Long id;
    private String nivel;
    private String aplicacion;

}
