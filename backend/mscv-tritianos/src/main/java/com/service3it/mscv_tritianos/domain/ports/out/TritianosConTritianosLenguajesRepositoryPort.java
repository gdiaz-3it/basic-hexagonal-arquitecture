package com.service3it.mscv_tritianos.domain.ports.out;

import java.util.List;

import com.service3it.mscv_tritianos.domain.models.TritianosConTritianosLenguajes;

public interface TritianosConTritianosLenguajesRepositoryPort {

    List<TritianosConTritianosLenguajes> getTritianosWithTritianoLenguajesUseCase();

    List<TritianosConTritianosLenguajes> getTritianosWithTritianoLenguajesUseCaseById(Long id);

}
