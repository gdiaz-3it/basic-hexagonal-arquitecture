package com.service3it.mscv_trinitianos.domain.ports.in;

import com.service3it.mscv_trinitianos.domain.models.Trinitianos;

public interface UpdateTrinitianoByIdUseCase {

    Trinitianos updateTrinitianoById(Long id, Trinitianos trinitianos);

}
