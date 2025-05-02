package com.service3it.mscv_tritianos.domain.ports.in;

import java.util.List;

import com.service3it.mscv_tritianos.infraestructure.adapters.in.rest.dto.TritianosConTritianoAplicacionesDTO;

public interface GetTritianosWithTritianoAplicacionesUseCase {

    List<TritianosConTritianoAplicacionesDTO> getTritianosWithTritianoAplicacionesUseCase();

}
