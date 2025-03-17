package com.service3it.mscv_trinitianos.domain.ports.in;

import com.service3it.mscv_trinitianos.domain.models.Trinitianos;

public interface GetTrinitianosByIdUseCase {

    Trinitianos getTrinitianosById(Long id);

}
