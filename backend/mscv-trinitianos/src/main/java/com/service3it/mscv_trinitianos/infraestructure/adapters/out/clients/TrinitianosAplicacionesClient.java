package com.service3it.mscv_trinitianos.infraestructure.adapters.out.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.service3it.mscv_trinitianos.infraestructure.adapters.in.rest.dto.TrinitianosAplicacionesDto;

@FeignClient(name = "mcsv-trinitianos-aplicaciones", url = "http://localhost:8085")
public interface TrinitianosAplicacionesClient {

    @GetMapping("/api/trinitianos-aplicaciones/cliente/{rut}")
    List<TrinitianosAplicacionesDto> getTrinitianosByRut(@PathVariable String rut);

}
