package com.service3it.mscv_tritianos.domain.ports.in;

import java.util.List;

import com.service3it.mscv_tritianos.domain.models.Tritianos;


public interface GetAllTritianosUseCase {

    List<Tritianos> getAllTritianos();

}
