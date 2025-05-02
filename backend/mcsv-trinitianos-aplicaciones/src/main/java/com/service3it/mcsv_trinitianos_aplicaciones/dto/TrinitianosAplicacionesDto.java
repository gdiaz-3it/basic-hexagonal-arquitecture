package com.service3it.mcsv_trinitianos_aplicaciones.dto;

import java.util.List;

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
    private List<AplicacionesDto> aplicacion;
    


}
