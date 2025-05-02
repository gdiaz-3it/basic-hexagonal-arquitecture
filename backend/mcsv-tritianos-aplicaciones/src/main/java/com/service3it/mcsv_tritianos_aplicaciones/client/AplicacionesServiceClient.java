package com.service3it.mcsv_tritianos_aplicaciones.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.service3it.mcsv_tritianos_aplicaciones.dto.AplicacionesDto;


@FeignClient(name = "mcsv-aplicaciones", url = "http://localhost:8084")
public interface AplicacionesServiceClient {

    @GetMapping("/api/aplicaciones/all")
    List<AplicacionesDto> findAllTritianosAplicacionesWithAplicaciones();

    @GetMapping("/api/aplicaciones/{nivel}")
    List<AplicacionesDto> getAplicacionByNivel(@PathVariable String nivel);

}
