package com.service3it.mscv_tritianos.infraestructure.adapters.out.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.service3it.mscv_tritianos.infraestructure.adapters.in.rest.dto.TritianosLenguajesDto;

@FeignClient(name = "mcsv-tritianos-lenguajes", url = "http://localhost:8083")
public interface TritianosLenguajesClient {

    @GetMapping("/api/tritianos-lenguajes/cliente/id/{id}")
    List<TritianosLenguajesDto> getTritianosById(@PathVariable Long id);

}
