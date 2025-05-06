package com.service3it.mscv_tritianos.domain.ports.in;

import java.util.List;

import com.service3it.mscv_tritianos.domain.models.TritianosConTritianosLenguajes;

public interface GetTritianosWithTritianoLenguajesByIdUseCase {

    List<TritianosConTritianosLenguajes> getTritianosWithTritianoLenguajesById(Long id);

}
