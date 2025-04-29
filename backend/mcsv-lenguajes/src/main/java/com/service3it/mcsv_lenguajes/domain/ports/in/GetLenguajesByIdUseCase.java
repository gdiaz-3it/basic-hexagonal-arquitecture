package com.service3it.mcsv_lenguajes.domain.ports.in;

import com.service3it.mcsv_lenguajes.domain.models.Lenguajes;

public interface GetLenguajesByIdUseCase {

    Lenguajes getLenguajeById(Long id);

}
