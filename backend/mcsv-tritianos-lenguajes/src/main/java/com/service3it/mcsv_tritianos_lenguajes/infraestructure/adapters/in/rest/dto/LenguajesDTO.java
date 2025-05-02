package com.service3it.mcsv_tritianos_lenguajes.infraestructure.adapters.in.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LenguajesDTO {

    private Long id;
    private String nombre;
    private String nivel;


}
