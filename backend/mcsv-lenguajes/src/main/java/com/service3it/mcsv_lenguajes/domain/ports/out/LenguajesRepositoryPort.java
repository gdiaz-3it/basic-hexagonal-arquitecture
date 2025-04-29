package com.service3it.mcsv_lenguajes.domain.ports.out;

import java.util.List;

import com.service3it.mcsv_lenguajes.domain.models.Lenguajes;

public interface LenguajesRepositoryPort {

    List<Lenguajes> getAllLenguajes();

    Lenguajes getLenguajeById(Long id);

    Lenguajes saveLenguaje(Lenguajes lenguajes);

    Lenguajes updateLenguajeById(Long id, Lenguajes lenguajes);

    void deleteLenguajeById(Long id);

}
