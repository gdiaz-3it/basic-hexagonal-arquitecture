package com.service3it.mscv_tritianos.domain.ports.in;

import com.service3it.mscv_tritianos.domain.models.Tritianos;

public interface UpdateTritianoByIdUseCase {

    Tritianos updateTritianoById(Long id, Tritianos tritianos);

}
