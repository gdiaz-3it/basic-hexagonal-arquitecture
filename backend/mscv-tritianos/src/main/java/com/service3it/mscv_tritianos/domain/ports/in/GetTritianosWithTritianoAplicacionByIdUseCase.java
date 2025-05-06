package com.service3it.mscv_tritianos.domain.ports.in;

import java.util.List;

import com.service3it.mscv_tritianos.domain.models.TritianosConTritianosAplicaciones;

public interface GetTritianosWithTritianoAplicacionByIdUseCase {

    List<TritianosConTritianosAplicaciones> getTritianosWithTritianoAplicacionesUseCaseById(Long id);

}
