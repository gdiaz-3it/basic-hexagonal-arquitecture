package com.service3it.mscv_trinitianos.domain.ports.in;

import java.util.List;

import com.service3it.mscv_trinitianos.domain.models.Trinitianos;

public interface GetAllTrinitianosUseCase {

    List<Trinitianos> getAllTrinitianos();

}
