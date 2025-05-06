package com.service3it.mscv_tritianos.domain.ports.out;

import java.util.List;

import com.service3it.mscv_tritianos.domain.models.TritianosConTritianosAplicaciones;

public interface TritianosConTritianosAplicacionesRepositoryPort {

    List<TritianosConTritianosAplicaciones> getTritianosWithTritianoAplicacionesUseCaseById(Long id);

}
