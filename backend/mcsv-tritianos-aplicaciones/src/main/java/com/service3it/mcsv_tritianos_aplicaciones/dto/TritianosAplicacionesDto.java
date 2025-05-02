package com.service3it.mcsv_tritianos_aplicaciones.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TritianosAplicacionesDto {

    private Long id;
    private String rut;
    private String nivel;
    private List<AplicacionesDto> aplicacion;
    


}
