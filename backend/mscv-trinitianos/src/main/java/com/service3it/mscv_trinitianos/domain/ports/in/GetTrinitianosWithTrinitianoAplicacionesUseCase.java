package com.service3it.mscv_trinitianos.domain.ports.in;

import java.util.List;

import com.service3it.mscv_trinitianos.infraestructure.adapters.in.rest.dto.TrinitianosConTrinitianoAplicacionesDTO;

public interface GetTrinitianosWithTrinitianoAplicacionesUseCase {

    List<TrinitianosConTrinitianoAplicacionesDTO> getTrinitianosWithTrinitianoAplicacionesUseCase();

}
