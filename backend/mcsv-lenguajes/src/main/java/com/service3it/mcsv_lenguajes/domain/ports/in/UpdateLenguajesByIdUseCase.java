package com.service3it.mcsv_lenguajes.domain.ports.in;

import com.service3it.mcsv_lenguajes.domain.models.Lenguajes;

public interface UpdateLenguajesByIdUseCase {

    Lenguajes updateTrinitianoById(Long id, Lenguajes lenguajes);

}
