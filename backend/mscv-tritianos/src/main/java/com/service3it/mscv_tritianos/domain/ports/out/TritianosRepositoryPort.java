package com.service3it.mscv_tritianos.domain.ports.out;

import java.util.List;

import com.service3it.mscv_tritianos.domain.models.Tritianos;

public interface TritianosRepositoryPort {

    Tritianos getTritianosById(Long id);

    Tritianos saveTritianos(Tritianos tritianos);

    List<Tritianos> getAllTritianos();

    void deleteTritianoById(Long id);

    Tritianos updateTritianoById(Long id, Tritianos tritianos);

}
