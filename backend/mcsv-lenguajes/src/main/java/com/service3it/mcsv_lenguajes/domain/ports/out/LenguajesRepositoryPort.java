package com.service3it.mcsv_lenguajes.domain.ports.out;

import java.util.List;

import com.service3it.mcsv_lenguajes.domain.models.Lenguajes;

public interface LenguajesRepositoryPort {

    List<Lenguajes> getAllLenguajes();

    Lenguajes getLenguajesById(Long id);

    Lenguajes saveLenguajes(Lenguajes lenguajes);

    Lenguajes updateLenguajesById(Long id, Lenguajes lenguajes);

    void deleteLenguajesById(Long id);

}
