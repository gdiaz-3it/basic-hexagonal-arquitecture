package com.service3it.mcsv_tritianos_lenguajes.infraestructure.adapters.out.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.service3it.mcsv_tritianos_lenguajes.infraestructure.adapters.in.rest.dto.LenguajesDTO;

@FeignClient(name = "mcsv-lenguajes", url = "http://localhost:8082")
public interface LenguajesClient {

    @GetMapping("/lenguaje-client/{id}")
    LenguajesDTO getLenguajeById(@PathVariable Long id);

}
