package com.service3it.mscv_tritianos.infraestructure.adapters.out.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.service3it.mscv_tritianos.infraestructure.adapters.in.rest.dto.TritianosAplicacionesDto;

@FeignClient(name = "mcsv-tritianos-aplicaciones", url = "http://localhost:8085")
public interface TritianosAplicacionesClient {

    @GetMapping("/api/tritianos-aplicaciones/cliente/{rut}")
    List<TritianosAplicacionesDto> getTritianosByRut(@PathVariable String rut);
    
}
